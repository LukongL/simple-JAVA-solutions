import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LibraryItem {
    private String title;
    private String author;
    private String itemID;

    public LibraryItem(String title, String author, String itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", itemID='" + itemID + '\'' +
                '}';
    }
}



class Catalog<T extends LibraryItem> {
    private Map<String, T> items = new HashMap<>();

    public void addItem(T item) {
        if (items.containsKey(item.getItemID())) {
            System.out.println("Item with ID " + item.getItemID() + " already exists.");
        } else {
            items.put(item.getItemID(), item);
            System.out.println("Item added: " + item);
        }
    }

    public void removeItem(String itemID) {
        if (items.containsKey(itemID)) {
            T removedItem = items.remove(itemID);
            System.out.println("Item removed: " + removedItem);
        } else {
            System.out.println("Item with ID " + itemID + " does not exist.");
        }
    }

    public T getItem(String itemID) {
        return items.get(itemID);
    }

    public void printCatalog() {
        System.out.println("Catalog:");
        for (T item : items.values()) {
            System.out.println(item);
        }
    }
}



public class LibraryCatalogApp {

    public static void main(String[] args) {
        Catalog<LibraryItem> catalog = new Catalog<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Catalog Menu:");
            System.out.println("1. Add a new item");
            System.out.println("2. Remove an item");
            System.out.println("3. View catalog");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = validateAndGetChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("Title cannot be empty. Retry");
                        break;
                    }

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine().trim();
                    if (author.isEmpty()) {
                        System.out.println("Author cannot be empty. Retry.");
                        break;
                    }

                    System.out.print("Enter item ID: ");
                    String itemID = scanner.nextLine().trim();
                    if (itemID.isEmpty()) {
                        System.out.println("Item ID cannot be empty. Retry");
                        break;
                    }

                    LibraryItem newItem = new LibraryItem(title, author, itemID);
                    catalog.addItem(newItem);
                    break;
                case 2:
                    System.out.print("Enter item ID to remove: ");
                    String removeID = scanner.nextLine().trim();
                    if (removeID.isEmpty()) {
                        System.out.println("Item ID cannot be empty. Retry.");
                        break;
                    }
                    catalog.removeItem(removeID);
                    break;
                case 3:
                    catalog.printCatalog();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Start over.");
            }
        }
    }

    private static int validateAndGetChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Choice out of range. Your choice must be a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Only numbers 1 to 4 are allowed.");
            }
            System.out.print("Enter your choice: ");
        }
        return choice;
    }
}
