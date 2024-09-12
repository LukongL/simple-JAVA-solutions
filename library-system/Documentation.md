LibrarySystem Program Documentation

Overview
The LibrarySystem program is a Java application designed to simulate a library management system. It provides basic functionalities such as adding books to the library, borrowing books, returning books, and exiting the program. The program utilizes the HashMap data structure to store information about the library's collection of books.

Class Structure

LibrarySystem Class
  1) Description: Represents the main class of the program responsible for managing the library system.
  2) Attributes: books: HashMap<String, Integer> - Stores the books in the library where the key is the book title (String) and the value is the quantity of the book (Integer).
  3) Methods: public LibrarySystem(): Constructor method for initializing the LibrarySystem object. Initializes the books HashMap.
     public void addBooks(String title, String author, int quantity): Method for adding books to the library. Updates the quantity of existing books or adds new books to the HashMap.
     public void borrowBooks(String title, int quantity): Method for borrowing books from the library. Checks if the requested books are available and updates the quantity accordingly.
     public void returnBooks(String title, int quantity): Method for returning books to the library. Updates the quantity of returned books in the HashMap.
     public static void main(String[] args): Main method responsible for program execution. Displays menu options, processes user input, and calls corresponding methods based on user choices.

Usage
  1) Adding Books: Choose option 1 from the menu, enter the title, author, and quantity of the book when prompted.
  2) Borrowing Books: Choose option 2 from the menu, enter the title of the book and the quantity to borrow when prompted.
  3) Returning Books: Choose option 3 from the menu, enter the title of the book and the quantity to return when prompted.
  4) Exiting the Program: Choose option 4 from the menu to exit the program.

Input Validation
  1) The program validates user input to ensure valid book titles, authors, quantities, and menu choices are provided.
  2) For book quantities, negative values and non-integer inputs are not accepted.

Contributions
Contributions to the LibrarySystem program are welcome! If you find any bugs, have suggestions for improvements, or would like to contribute new features, please feel free to open an issue or submit a pull request on GitHub.

License
This project is licensed under the MIT License. See the LICENSE file for details.
