# Student-Management-GUI-Application

Overview

The Student Management System GUI is a JavaFX-based application designed to manage students and courses efficiently. It allows users to add, update, and delete students and courses, enroll students in courses, assign grades, and calculate average and overall grades.

Features

Student Management

	Add, update, and delete student records.
	
	Enroll students in courses.
	
	Assign grades to students for specific courses.
	
	Calculate the average grade for a student in a specific course.
	
	Calculate the overall grade for a student across all enrolled courses.

Course Management

	Add, update, and delete course records.
	
	View all courses and their details.
	
	Manage course enrollment and capacity.

Getting Started

Prerequisites

	Java Development Kit (JDK) 8 or higher
	
	JavaFX SDK

Installation

	Ensure that the JavaFX libraries are properly configured in your project.
	
	Copy the provided source code into your project.

Running the Application

	Compile and run the StudentManagementGUI class.
	
	The main window will open with tabs for managing students and courses.

Usage

Student Management Tab

Adding a Student

	Enter the student's name and ID in the respective fields.
	
	Click the "Add Student" button to add the student to the list.

Updating a Student

	Select a student from the list.
	
	Modify the student's name and/or ID in the respective fields.
	
	Click the "Update Student" button to save the changes.

Deleting a Student

	Select a student from the list.
	
	Click the "Delete Student" button to remove the student.
	
Enrolling in a Course

	Select a student from the list.
	
	Choose a course from the "Enroll in Course" dropdown.
	
	Click the "Enroll" button to enroll the student in the selected course.

Assigning a Grade

	Select a student from the list.
	
	Choose a course from the "Assign Grade" dropdown.
	
	Enter the grade in the "Grade" field.
	
	Click the "Assign Grade" button to assign the grade to the student.

Calculating Average Grade

	Select a student from the list.

	Choose a course from the "Enroll in Course" dropdown.
	
	Click the "Calculate Average Grade" button to view the student's average grade for the selected course.

Calculating Overall Grade

	Select a student from the list.
	
	Click the "Calculate Overall Grade" button to view the student's overall grade across all enrolled courses.

Course Management Tab

Adding a Course

	Enter the course code, name, and maximum capacity in the respective fields.
	
	Click the "Add Course" button to add the course to the list.

Updating a Course

	Select a course from the list.

	Modify the course code, name, and/or maximum capacity in the respective fields.
	
	Click the "Update Course" button to save the changes.

Deleting a Course

	Select a course from the list.
	
	Click the "Delete Course" button to remove the course.

Validation

Student Input

	Name and ID fields must not be empty.
	
	Proper validation messages will be displayed for incorrect inputs.

Course Input

	Course code, name, and maximum capacity fields must not be empty.
	
	Maximum capacity must be a positive number.
	
	Proper validation messages will be displayed for incorrect inputs.

Grade Input

	Grade must be between 0 and 100.
	
	Proper validation messages will be displayed for incorrect inputs.

Author 

Liliane Lukong - liliane.haniel@gmail.com
