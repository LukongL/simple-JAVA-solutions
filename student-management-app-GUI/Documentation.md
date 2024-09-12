StudentManagementGUI Documentation

Overview

The StudentManagementGUI application is a JavaFX-based graphical user interface for managing students and courses. Users can add, update, delete students and courses, enroll students in courses, assign grades, and calculate average and overall grades for students. The application ensures that inputs are validated to maintain data integrity.

Components

1.	Main Class: StudentManagementGUI

	•	Extends Application.
	  
	•	Entry point for the JavaFX application.
	  
	•	Contains the main method to launch the application and the start method to set up the primary stage.

3.	Student Class
   
	•	Represents a student with name, id, and a list of enrolled courses.
	  
	•	Methods: getName(), getId(), setName(), setId(), getEnrolledCourses(), enrollCourse(), assignGrade().

5.	Course Class
   
	•	Represents a course with courseCode, name, maxCapacity, enrolledStudents, and studentGradesById.
	  
	•	Methods: getCourseCode(), getName(), getMaxCapacity(), getEnrolledStudents(), setCourseCode(), setName(), setMaxCapacity(), enrollStudent(), setGrade(), getGrades().
	  
	•	Overrides toString() to return the course name.

7.	CourseManagement Class
   
	•	Manages the list of courses.
	  
	•	Methods: addCourse(), getCourse(), updateCourse(), removeCourse(), enrollStudent(), assignGrade(), calculateAverageCourseGrade(), calculateOverallGrade(), listCourses(), getCourses().

9.	GUI Components and Layouts
   
	•	TabPane: Contains tabs for Student Management and Course Management.
	  
	•	GridPane: Layout for arranging components in a grid format.
	  
	•	ListView: Displays the list of students and courses.
	  
	•	TextField: For input fields (name, id, course code, course name, max capacity, grade).
	  
	•	ComboBox: For selecting courses when enrolling students or assigning grades.
	
	•	Button: For performing actions (add, update, delete, enroll, assign grade, calculate grades).

GUI Design

	•	TabPane: Separates student and course management into distinct tabs for better organization and usability.
	
	•	GridPane: Provides a structured layout for input fields and buttons.
	  
	•	ListView: Displays students and courses by their names using custom cell factories for clarity and ease of selection.
	  
	•	ComboBox: Allows selecting courses from a dropdown list, enhancing user experience when enrolling students or assigning grades.

Event Handlers

•	Add, Update, Delete Students:

	•	Add: Validates inputs and adds a new student to the list.
	  
	•	Update: Validates inputs and updates the selected student's details.
	  
	•	Delete: Removes the selected student from the list.

•	Enroll Student in Course:

	•	Validates selection and enrolls the selected student in the selected course.

•	Assign Grade:

	•	Validates inputs and assigns a grade to the selected student for the selected course.

•	Calculate Average and Overall Grades:

	•	Calculates and displays the average grade for a course or the overall grade across all courses for the selected student.

Input Validations

	•	Student Name and ID: Checks if the fields are not empty.
	
	•	Course Code, Name, and Max Capacity: Checks if the fields are not empty and if max capacity is a valid integer.
	
	•	Grade: Checks if the grade is a number between 0 and 100.

Instructions for Running the Program

1.	Setup:

	•	Ensure you have Java and JavaFX installed.
	  
	•	Save the code into appropriate .java files in a project directory.

3.	Compile and Run:

	•	Navigate to the project directory.
	  
	•	Compile the program using javac:
	
		javac -cp /path/to/javafx-sdk/lib --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls StudentManagementGUI.java
	
	•	Run the program:
	
		java -cp .:/path/to/javafx-sdk/lib --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls StudentManagementGUI 

Interacting with the GUI

1.	Student Management Tab:

	•	Add Student: Enter name and ID, then click "Add Student".
	  
	•	Update Student: Select a student from the list, modify details, and click "Update Student".
	  
	•	Delete Student: Select a student from the list and click "Delete Student".
	  
	•	Enroll in Course: Select a student and a course, then click "Enroll".
	  
	•	Assign Grade: Select a student and a course, enter a grade, and click "Assign Grade".
	  
	•	Calculate Average Grade: Select a student and a course, then click "Calculate Average Grade".
	
	•	Calculate Overall Grade: Select a student and click "Calculate Overall Grade".

3.	Course Management Tab:

	•	Add Course: Enter course code, name, and max capacity, then click "Add Course".
	  
	•	Update Course: Select a course from the list, modify details, and click "Update Course".
	  
	•	Delete Course: Select a course from the list and click "Delete Course".

Design Choices

	•	TabPane: Separates functionality for clarity and organization.
	  
	•	GridPane: Provides a clean and organized layout for input fields and buttons.
	  
	•	ListView: Displays names for easy identification and selection of students and courses.
	  
	•	ComboBox: Simplifies course selection for enrolling students and assigning grades.
	  
	•	Input Validations: Ensures data integrity and provides feedback to users on invalid inputs.
	  
	•	Alerts: Used to notify users of validation errors or important actions.

This design ensures an intuitive and user-friendly interface while maintaining robust functionality for managing students and courses.
