import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentRecordManagementSystem {
    // Static ArrayLists to store student information
    private static ArrayList<String> studentNames = new ArrayList<>();
    private static ArrayList<Integer> studentIDs = new ArrayList<>();
    private static ArrayList<Integer> studentAges = new ArrayList<>();
    private static ArrayList<Character> studentGrades = new ArrayList<>();

    // Method to add a new student
    private static void addStudent(String name, int id, int age, char grade) {
        // Add student details to respective ArrayLists
        studentNames.add(name);
        studentIDs.add(id);
        studentAges.add(age);
        studentGrades.add(grade);
        // Print success message
        System.out.println("Student added successfully.");
    }

    // Method to update student information
    private static void updateStudent(int id, int age, char grade) {
        // Find index of student with given ID
        int index = findStudentIndex(id);
        if (index != -1) {
            // Update age and grade of student at found index
            studentAges.set(index, age);
            studentGrades.set(index, grade);
            // Print success message
            System.out.println("Student information updated successfully.");
        } else {
            // Print error message if student ID not found
            System.out.println("Error: Student ID not found.");
            return; // Exit the method if ID is not found, no further input is prompted
        }
    }

    // Method to find student index by ID
    private static int findStudentIndex(int id) {
        // Iterate through student IDs ArrayList
        for (int i = 0; i < studentIDs.size(); i++) {
            // Check if current ID matches the given ID
            if (studentIDs.get(i) == id) {
                // Return index if match found
                return i;
            }
        }
        // Return -1 if no match found
        return -1;
    }

    // Method to view student details
    private static void viewStudentDetails(int id) {
        // Find index of student with given ID
        int index = findStudentIndex(id);
        if (index != -1) {
            // Print details of student at found index
            System.out.println("Name: " + studentNames.get(index));
            System.out.println("ID: " + studentIDs.get(index));
            System.out.println("Age: " + studentAges.get(index));
            System.out.println("Grade: " + studentGrades.get(index));
        } else {
            // Print error message if student ID not found
            System.out.println("Error: Student ID not found.");
        }
    }

    // Method to display administrator menu
    private static void displayMenu() {
        // Display menu options
        System.out.println("\nAdministrator Menu:");
        System.out.println("1. Add New Student");
        System.out.println("2. Update Student Information");
        System.out.println("3. View Student Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Display menu and read user's choice with input validation
            displayMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Check if the choice is within the range of 1 to 4
                if (choice < 1 || choice > 4) {
                    throw new InputMismatchException();
                }

                // Perform actions based on user's choice
                switch (choice) {
                    case 1:
                        // Prompt user to enter new student details
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter student grade: ");
                        char grade = scanner.next().charAt(0);
                        scanner.nextLine(); // Consume newline character
                        // Add new student with entered details
                        addStudent(name, id, age, grade);
                        break;
                    case 2:
                        // Prompt user to enter student ID to update
                        System.out.print("Enter student ID to update: ");
                        int updateID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        
                        // Check if the entered ID exists before proceeding
                        if(findStudentIndex(updateID) != -1) {
                            // Prompt user to enter updated information
                            System.out.print("Enter updated student age: ");
                            int updateAge = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character
                            System.out.print("Enter updated student grade: ");
                            char updateGrade = scanner.next().charAt(0);
                            scanner.nextLine(); // Consume newline character
                            // Update student information with entered details
                            updateStudent(updateID, updateAge, updateGrade);
                        } else {
                            // Print error message if student ID not found
                            System.out.println("Error: Student ID not found.");
                        }
                        break;
                    case 3:
                        // Prompt user to enter student ID to view details
                        System.out.print("Enter student ID to view details: ");
                        int viewID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        // View details of student with entered ID
                        viewStudentDetails(viewID);
                        break;
                    case 4:
                        // Exit the program
                        System.out.println("Exiting program...");
                        break;
                }
            } catch (InputMismatchException e) {
                // Print error message for invalid input
                System.out.println("Invalid input! Please enter a number from 1 to 4.");
                choice = 0; // Reset choice to trigger re-prompt
                scanner.nextLine(); // Consume newline character
            }
        } while (choice != 4); // Continue loop until user chooses to exit

        // Close the Scanner object
        scanner.close();
    }
}
