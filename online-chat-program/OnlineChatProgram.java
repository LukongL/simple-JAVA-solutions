import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.Scanner;

public class OnlineChatProgram {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("server")) {
            new ChatServer().start();
        } else {
            new ChatClient().start();
        }
    }

    private static class ChatServer {
        private static int assignClientIdCounter = 0;
        private static final int PORT = 22227;
        private static final Set<HandleConnectedClient> handleConnectedClients = ConcurrentHashMap.newKeySet();

        public void start() {
            System.out.println("Chat server is ready to accept connections...");
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                while (true) {
                    Socket socket = serverSocket.accept();
                    HandleConnectedClient handleConnectedClient = new HandleConnectedClient(socket, assignClientIdCounter++);
                    handleConnectedClients.add(handleConnectedClient);
                    new Thread(handleConnectedClient).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void postMessage(String message, HandleConnectedClient sender) {
            for (HandleConnectedClient client : handleConnectedClients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }

        private static class HandleConnectedClient implements Runnable {
            private final Socket socket;
            private final int clientId;
            private PrintWriter out;

            public HandleConnectedClient(Socket socket, int clientId) {
                this.socket = socket;
                this.clientId = clientId;
            }

            @Override
            public void run() {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("You are now connected to the server. Your ID is: " + clientId);
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Message from client " + clientId + ": " + message);
                        if ("quit".equalsIgnoreCase(message.trim())) {
                            break; // Exit the loop if the client sends "quit"
                        }
                        ChatServer.postMessage("Client " + clientId + ": " + message, this);
                    }
                } catch (IOException e) {
                    System.out.println("Connection with client " + clientId + " closed.");
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    handleConnectedClients.remove(this);
                    ChatServer.postMessage("Client " + clientId + " has disconnected.", this);
                }
            }

            public void sendMessage(String message) {
                if (out != null) {
                    out.println(message);
                }
            }
        }
    }

    private static class ChatClient {
        private static final String SERVER_ADDRESS = "localhost";
        private static final int SERVER_PORT = 22227;

        public void start() {
            try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 Scanner scanner = new Scanner(System.in)) {

                System.out.println("Connected to the chat server.");
                Thread receiverThread = new Thread(() -> {
                    try {
                        String incomingMessage;
                        while ((incomingMessage = in.readLine()) != null) {
                            System.out.println(incomingMessage);
                        }
                    } catch (IOException e) {
                        System.out.println("Disconnected from server.");
                    }
                });
                receiverThread.start();

                while (true) {
                    String message = scanner.nextLine();
                    out.println(message);
                    if ("quit".equalsIgnoreCase(message.trim())) {
                        break; // Exit the loop if the user types "quit"
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
