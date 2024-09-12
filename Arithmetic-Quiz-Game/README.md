# ArithmeticQuiZGame

Overview
The Arithmetic Quiz Game is a simple Java program that prompts the user with five multiple-choice arithmetic questions. It allows them to enter their answers (typed as A, B, C, or D), validates user inputs to ensure they are within the expected range, and compares their answers to the correct ones using if statements and a switch-case statement. Finally, it calculates the final score as a percentage.

How to Use
1) Running the Program: Compile and run the ArithmeticQuizGame.java file using a Java compiler or an IDE that supports Java development.
2) Answering Questions: Once the program is running, it will display each question along with multiple-choice options (A, B, C, or D). Enter your answer by typing the corresponding letter (e.g., A for option A). If your input is invalid (not A, B, C, or D), the program will prompt you to enter a valid answer.
3) Scoring: After answering all five questions, the program will calculate your final score as a percentage based on the number of correct answers. Your score will be displayed on the screen.

Program Structure
1) Questions and Options: The program defines an array of questions, an array of options for each question, and an array of correct answers.
2) Input Validation: User input is validated to ensure it is a single character (A, B, C, or D). If the input is invalid, the program prompts the user to enter a valid answer.
3) Scoring Mechanism: The program compares the user's answers to the correct answers using a helper method (isAnswerCorrect). The score is updated based on the number of correct answers.
4) Final Score Calculation: The final score is calculated as a percentage of correct answers out of the total number of questions.

Contributing
Contributions to the Arithmetic Quiz Game program are welcome! If you find any bugs, have suggestions for improvements, or would like to contribute new features, please feel free to open an issue or submit a pull request on GitHub.

License
This project is open-source and available under the MIT License. See the LICENSE file for details.
