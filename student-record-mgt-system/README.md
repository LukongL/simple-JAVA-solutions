
# Student-Record-Management-System
Student Record Management System

Overview

The Student Record Management System is a simple Java console application designed to manage student records. It allows administrators to add new students, update existing student information, and view student details. This system uses ArrayLists to store and manage student data such as names, IDs, ages, and grades.

Features

		•	Add New Student: Allows administrators to add a new student by entering their name, ID, age, and grade.
  
		•	Update Student Information: Enables updating the age and grade of an existing student based on their ID.
  
		•	View Student Details: Provides the ability to view the details of a student by entering their ID.
  
		•	Exit: Allows the user to exit the application.

Getting Started

	Prerequisites
			•	Java Development Kit (JDK) installed on your machine.
   
			•	A Java IDE or a simple text editor.
   
			•	A command-line interface (CLI) for running the Java program.
Installation

		1.	Clone or download the repository:
 
				o	Clone the repository using Git:
				git clone https://github.com/yourusername/StudentRecordManagementSystem.git
    
				o	Or download the ZIP file and extract it to a directory of your choice.
    
		2.	Navigate to the project directory:
  
				cd StudentRecordManagementSystem
    
		3.	Compile the Java file:
  
				javac StudentRecordManagementSystem.java
    
		4.	Run the application:
  
				java StudentRecordManagementSystem

Usage

Menu Options

Upon running the program, you will be presented with the following menu:

Administrator Menu:
1. Add New Student
2. Update Student Information
3. View Student Details
4. Exit
Enter your choice (1-4):

Adding a New Student
To add a new student:
1.	Choose option 1.
2.	Enter the student name, ID, age, and grade when prompted.
3.	A message will confirm the student has been added successfully.
   
Updating Student Information
To update student information:
1.	Choose option 2.
2.	Enter the student ID of the student you want to update.
3.	If the student ID exists, you will be prompted to enter the updated age and grade.
4.	A message will confirm the student information has been updated successfully.
   
Viewing Student Details
To view student details:
1.	Choose option 3.
2.	Enter the student ID of the student you want to view.
3.	The system will display the student's name, ID, age, and grade if the ID is found.
   
Exiting the Application
To exit the application:
1.	Choose option 4.
2.	The program will display a message and terminate.
   
Example
Below is a brief interaction example with the system:
Administrator Menu:
1. Add New Student
2. Update Student Information
3. View Student Details
4. Exit
Enter your choice (1-4): 1

Enter student name: John Doe
Enter student ID: 101
Enter student age: 20
Enter student grade: A
Student added successfully.

Administrator Menu:
1. Add New Student
2. Update Student Information
3. View Student Details
4. Exit
Enter your choice (1-4): 3

Enter student ID to view details: 101
Name: John Doe
ID: 101
Age: 20
Grade: A

Administrator Menu:
1. Add New Student
2. Update Student Information
3. View Student Details
4. Exit
Enter your choice (1-4): 4

Exiting program...

Code Explanation
•	ArrayLists: Used to store student names, IDs, ages, and grades.
•	addStudent: Adds a new student to the ArrayLists.
•	updateStudent: Updates the age and grade of a student identified by their ID.
•	findStudentIndex: Finds the index of a student based on their ID.
•	viewStudentDetails: Displays the details of a student based on their ID.
•	displayMenu: Displays the administrator menu options.
•	main: The main method where the program execution begins. Handles user input and menu navigation.

Contributions
Contributions are welcome! If you have any ideas or improvements, feel free to submit a pull request or open an issue.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Author
Liliane Lukong – liliane.haniel@gmail.com

