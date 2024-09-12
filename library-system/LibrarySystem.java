
/**
 * This program mimics a basic library management system. 
 * It allows users to add books to the library, borrow books, return books, and exit the program. 
 * The LibrarySystem class encapsulates the functionality, 
 * with methods for adding books, borrowing books, returning books, and the main method for program execution. 
 * The books are stored in a HashMap where the title maps to the quantity of each book. 
 * Input validation is implemented to handle invalid user input.
 */

import java.util.HashMap;
import java.util.Scanner;

public class LibrarySystem {
    private HashMap<String, Integer> books;

    public LibrarySystem() {
        books = new HashMap<>();
    }

    public void addBooks(String title, String author, int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be a positive integer.");
            return; // input validation
        }

        if (books.containsKey(title)) {
            // If book already exists, update the quantity
            int currentQuantity = books.get(title);
            books.put(title, currentQuantity + quantity);
            System.out.println("Quantity of '" + title + "' updated to " + (currentQuantity + quantity));
        } else {
            // If book is new, add it to the library
            books.put(title, quantity);
            System.out.println("Book '" + title + "' by " + author + " added with quantity " + quantity);
        }
    }

    public void borrowBooks(String title, int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be a positive integer.");
            return; // input validation
        }

        if (books.containsKey(title)) {
            int availableQuantity = books.get(title);
            if (availableQuantity >= quantity) {
                books.put(title, availableQuantity - quantity);
                System.out.println("Successfully borrowed " + quantity + " copies of '" + title + "'");
            } else {
                System.out.println("Error: Insufficient copies of '" + title + "' available");
            }
        } else {
            System.out.println("Error: Book '" + title + "' not found in library");
        }
    }

    public void returnBooks(String title, int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be a positive integer.");
            return; // input validation
        }

        if (books.containsKey(title)) {
            int currentQuantity = books.get(title);
            books.put(title, currentQuantity + quantity);
            System.out.println("Successfully returned " + quantity + " copies of '" + title + "'");
        } else {
            System.out.println("Error: Book '" + title + "' not found in library");
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        // Main loop for displaying options and processing user input
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Input validation for integer option
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer option.");
                scanner.nextLine(); // consume newline character
                continue; // input validation
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter quantity: ");

                    // input validation for interger quantity
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: Please enter a valid integer quantity.");
                        scanner.nextLine(); // consume newline character
                        break; // input validation
                    }

                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    library.addBooks(title, author, quantity);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.print("Enter quantity to borrow: ");
                    
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: Please enter a valid integer quantity.");
                        scanner.nextLine(); // consume newline character
                        break;
                    }

                    int borrowQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    library.borrowBooks(borrowTitle, borrowQuantity);
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Enter quantity to return: ");
                    
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: Please enter a valid integer quantity.");
                        scanner.nextLine(); // consume newline character
                        break;
                    }

                    int returnQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    library.returnBooks(returnTitle, returnQuantity);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        }
    }
}

 

 

 
 


