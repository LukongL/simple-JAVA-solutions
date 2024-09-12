import java.util.Scanner;

public class ArithmeticQuizGame {
    public static void main(String[] args) {
        // Define the questions and their options
        String[] questions = {
            "What is the result of 2 + 2?",
            "What is the result of 8 / 2?",
            "What is the result of 5 * 3?",
            "What is the result of 10 - 7?",
            "What is the square root of 16?"
        };
        
        String[][] options = {
            {"A. 3", "B. 4", "C. 5", "D. 6"},
            {"A. 2", "B. 3", "C. 4", "D. 5"},
            {"A. 10", "B. 12", "C. 15", "D. 20"},
            {"A. 2", "B. 3", "C. 4", "D. 5"},
            {"A. 2", "B. 4", "C. 8", "D. 16"}
        };
        
        char[] answers = {'B', 'C', 'C', 'B', 'B'}; // Correct answers
        
        // Initialize variables to track user's score and input
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        
        // Display each question and options, and prompt user for their answer
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            // Prompt user for their answer and validate input
            char userAnswer;
            do {
                System.out.print("Enter your answer (A, B, C, or D): ");
                String userInput = scanner.next().toUpperCase(); // Read user input as a string and convert to uppercase
                // Validate user input
                if (userInput.length() != 1 || userInput.charAt(0) < 'A' || userInput.charAt(0) > 'D') {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                    continue; // Skip processing this input and prompt user again
                }
                userAnswer = userInput.charAt(0); // Convert input to char
                break; // Exit the loop if input is valid
            } while (true);
            
            // Compare user's answer to correct answer and update score accordingly
            if (isAnswerCorrect(userAnswer, answers[i])) {
                score++;
            }
        }
        
        // Compute and display final score as a percentage
        double percentageScore = (double) score / questions.length * 100;
        System.out.println("\nYour final score: " + percentageScore + "%");
        
        // Close scanner to release resources
        scanner.close();
    }
    
    // Helper method to check if user's answer matches the correct answer
    private static boolean isAnswerCorrect(char userAnswer, char correctAnswer) {
        // Using switch case statement for comparison
        switch (userAnswer) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
                return userAnswer == correctAnswer;
            default:
                return false;
        }
    }
}
