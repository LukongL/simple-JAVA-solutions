Course Enrollment and Grade Management System Documentation

Project Overview

The Course Enrollment and Grade Management System is designed to facilitate the management of student enrollments, assignment of grades, and calculation of average and overall grades for students in a university setting. The system uses object-oriented design principles, such as encapsulation and modularity, and provides a user-friendly command-line interface for administrators to interact with the system.

Key Features

	•	Encapsulation: Use of private fields and public methods to protect and manage the internal state of objects.
	
	•	Modularity: Separation of functionality into different classes for better organization and reusability.
	
	•	Static Methods and Variables: Utilization of static methods and variables to manage shared data across the system.
	
	•	Interactive Command-Line Interface: An intuitive command-line interface that guides administrators through various operations.

Class Descriptions

Student Class

The Student class represents a student in the system.

•	Fields:

	•	name (private String): The student's name.
	
	•	id (private String): The student's ID.
	
	•	enrolledCourses (private List<Course>): A list of courses the student is enrolled in.

•	Methods:

	•	Student(String name, String id): Constructor to initialize a student with a name and ID.
	
	•	String getName(): Returns the student's name.
	
	•	String getId(): Returns the student's ID.
	
	•	void setName(String name): Updates the student's name.

	•	void setId(String id): Updates the student's ID.
	
	•	List<Course> getEnrolledCourses(): Returns the list of enrolled courses.
	
	•	void enrollCourse(Course course): Enrolls the student in a course.
	
	•	int getTotalEnrolledStudents(): Retrieves total enrolled students
	
	•	void assignGrade(Course course, int grade): Assigns a grade to the student for a specific course.

Course Class

The Course class represents a course in the system.

•	Fields:

	•	courseCode (private String): The course code.
	
	•	name (private String): The course name.
	
	•	maxCapacity (private int): The maximum capacity of the course.
	
	•	enrolledStudents (private int): The number of students currently enrolled.
	
	•	studentGradesById (private Map<String, List<Integer>>): A map to store grades by student ID.

•	Methods:

	•	Course(String courseCode, String name, int maxCapacity): Constructor to initialize a course with a code, name, and maximum capacity.
	
	•	String getCourseCode(): Returns the course code.
 
	•	String getName(): Returns the course name.
 
	•	int getMaxCapacity(): Returns the maximum capacity.
 
	•	int getEnrolledStudents(): Returns the number of enrolled students.
 
	•	void setCourseCode(String courseCode): Updates the course code.
 
	•	void setName(String name): Updates the course name.
 
	•	void setMaxCapacity(int maxCapacity): Updates the maximum capacity.
 
	•	void enrollStudent(): Increases the number of enrolled students by one.
 
	•	void setGrade(Student student, int grade): Assigns a grade to a student for the course.
 
	•	List<Integer> getGrades(Student student): Returns the grades of a student for the course.

CourseManagement Class

The CourseManagement class handles the management of courses and students.

•	Fields:

	•	courses (private static List<Course>): A static list to store all courses.
 
•	Methods:

	•	static void addCourse(String courseCode, String name, int maxCapacity): Adds a new course to the system.
 
	•	static Course getCourse(int index): Retrieves a course by its index.
 
	•	static void updateCourse(int index, String courseCode, String name, int maxCapacity): Updates the details of an existing course.
 
	•	static void removeCourse(int index): Removes a course from the system.
 
	•	static void enrollStudent(Student student, Course course): Enrolls a student in a course.
 
	•	static void assignGrade(Student student, Course course, int grade): Assigns a grade to a student for a course.
 
	•	static void calculateAverageCourseGrade(Student student): Calculates the average grade for a student in a specific course.
 
	•	static void calculateOverallGrade(Student student): Calculates the overall grade for a student across all courses.
 
	•	static void listCourses(): Lists all available courses.

Main Class

The Main class provides the command-line interface for interacting with the system.

•	Fields:

	•	scanner (private static Scanner): Scanner object for reading user input.
 
	•	students (private static List<Student>): A list to store all students.
 
•	Methods:

	•	public static void main(String[] args): The main method to start the program.
 
	•	private static void displayMenu(): Displays the main menu.
 
	•	private static int getUserChoice(): Gets the user's menu choice.
 
	•	private static void addNewCourse(): Handles the addition of a new course.
 
	•	private static void enrollStudent(): Handles student enrollment in a course.

	•	private static void assignGrade(): Handles grade assignment to a student.
 
	•	private static void calculateAverageCourseGrade(): Handles the calculation of average course grade for a student.
 
	•	private static void calculateOverallGrade(): Handles the calculation of overall grade for a student.
 
	•	private static void updateStudentInfo(): Handles updating student information.
 
	•	private static void updateCourse(): Handles updating a course.
 
	•	private static void removeCourse(): Handles removing a course.
 
	•	private static Student findStudentById(String studentId): Finds a student by their ID.

Utilization of Static Methods and Variables

	•	Static Methods: Static methods in the CourseManagement class, such as addCourse, getCourse, and enrollStudent, manage shared data and actions that are not specific to any single instance of a class.
 
	•	Static Variables: The courses list in the CourseManagement class is static, allowing it to maintain a centralized list of all courses across the entire system.

Running the Program

	1.	Compile the program using a Java compiler:
 
javac Main.java 

	2.	Run the compiled program:
 
java Main 

	3.	Follow the on-screen instructions to interact with the system. Use the menu to add courses, enroll students, assign grades, and perform other administrative tasks.

Interacting with the Administrator Interface

1.	Add a New Course:
   
	•	Choose option 1 from the main menu.

	•	Enter the course code, name, and maximum capacity when prompted.

3.	Enroll a Student in a Course:
   
	•	Choose option 2 from the main menu.

	•	Enter the student's name and ID.

	•	Select a course from the list of available courses.

5.	Assign Grade to a Student:
   
	•	Choose option 3 from the main menu.

	•	Enter the student's ID and select the course.

	•	Enter the grade to be assigned.

7.	Calculate Average Course Grade for a Student:
   
	•	Choose option 4 from the main menu.

	•	Enter the student's ID and select the course.

9.	Calculate Overall Grade for Student Across All Courses:
    
	•	Choose option 5 from the main menu.

	•	Enter the student's ID.

11.	Update Student Information:
    
	•	Choose option 6 from the main menu.

	•	Enter the student's current ID and new information.

13.	Update a Course:
    
	•	Choose option 7 from the main menu.

	•	Select the course to update and enter the new details.

15.	Remove a Course:
    
	•	Choose option 8 from the main menu.

	•	Select the course to remove.

By following these instructions, administrators can effectively manage courses and student enrollments, ensuring a smooth and efficient academic experience.
