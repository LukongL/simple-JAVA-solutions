DOCUMENTATION

Program Overview:
This program is designed to manage student records through a command-line interface. It allows administrators to perform several operations, including adding new students, updating existing student information, viewing student details, and exiting the program.

Features:
1)	Add New Student: Administrators can add a new student by providing their name, ID, age, and grade.
2)	Update Student Information: Existing student information can be updated based on the student's ID. Administrators can modify the age and grade of the student.
3)	View Student Details: Administrators can view the details (name, ID, age, and grade) of a student by entering their ID.
4)	Exit: Administrators can exit the program when done managing student records.

Implementation Details:
•	The program utilizes ArrayLists (studentNames, studentIDs, studentAges, studentGrades) to store student information.
•	Input validation is performed using try-catch blocks to handle invalid user inputs during menu selection.
•	The program provides a menu interface for administrators to interact with the system.

Instructions for Running the Program:
1.	Compile the Program:
•	Save the provided code in a file named StudentRecordManagementSystem.java.
•	Open a terminal or command prompt.
•	Navigate to the directory containing the StudentRecordManagementSystem.java file.
•	Compile the program using the command: javac StudentRecordManagementSystem.java.
2. Run the Program:
•	After compiling, run the program using the command: java StudentRecordManagementSystem.
•	The program will start, displaying the administrator menu.

3.	Interacting with the Administrator Interface:
•	Upon running the program, administrators will be presented with a menu containing four options.
•	Enter a number from 1 to 4 to select an operation:
	Add New Student: Enter student details when prompted.
	Update Student Information: Enter the student ID to update, then provide new age and grade.
	View Student Details: Enter the student ID to view their details.
	Exit: Choose this option to exit the program.
	Invalid inputs will prompt error messages, and administrators will be asked to re-enter valid inputs.

Example Usage:

		Administrator Menu:
		1. Add New Student
		2. Update Student Information
		3. View Student Details
		4. Exit
		Enter your choice (1-4): 1
		
		Enter student name: Becky Li
		Enter student ID: 100001
		Enter student age: 10
		Enter student grade: 5
		Student added successfully.

		Administrator Menu:
		1. Add New Student
		2. Update Student Information
		3. View Student Details
		4. Exit
		Enter your choice (1-4): 3
		
		Enter student ID to view details: 100001
		Name: Becky Li
		ID: 100001
		Age: 10
		Grade: 5
		
		Administrator Menu:
		1. Add New Student
		2. Update Student Information
		3. View Student Details
		4. Exit
		Enter your choice (1-4): 4
		
		Exiting program...



Note:
	Ensure proper input format and follow the instructions provided by the program for smooth interaction.
	Administrators can continue managing student records until they choose to exit the program.
