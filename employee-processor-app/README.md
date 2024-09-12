# Employee-Processor-Application

Overview

The Employee Processor Program is a Java application designed to demonstrate the usage of Java Streams and Lambda Expressions to process a list of employees. It performs the following operations:

	Concatenates the name and department of each employee.
	
	Calculates the average salary of employees.
	
	Filters employees based on a specified age threshold.

Features

1. Concatenate Name and Department
   
	Concatenates each employee's name and department into a single string.
	
	Generates a list of these concatenated strings.

4. Calculate Average Salary
   
	Computes the average salary of all employees in the dataset.

6. Filter Employees by Age

	Filters the list of employees to include only those whose age is greater than a specified threshold.

Getting Started

Prerequisites

	Java Development Kit (JDK) 8 or higher

Installation

	Ensure that the JDK is installed and properly configured on your machine.
	
	Copy the provided source code into your project.

Running the Application

	Compile and run the EmployeeProcessor class.

	The program will execute and display the results of the various operations on the console.

Usage

Sample Dataset

The program uses a predefined list of employees:

	List<Employee> employees = Arrays.asList(
	    new Employee("Becky", 40, "Finance", 100000),
	    new Employee("Li", 38, "Operations", 120000),
	    new Employee("Sandra", 45, "Sales", 95000),
	    new Employee("Kent", 25, "Operations", 105000),
	    new Employee("Stone", 30, "Finance", 72000)
	);

Operations

1. Concatenate Name and Department

	A function is defined to concatenate the name and department of each employee.
	
	The program maps this function over the list of employees and collects the results into a list.

	The concatenated list is then printed.

3. Calculate Average Salary

	The program calculates the average salary of all employees using the average() method of DoubleStream.
	
	The result is printed to the console.

5. Filter Employees by Age

	The program filters employees whose age is greater than 30.
	
	The filtered list is printed to the console.

Code Explanation

Employee Class

	The Employee class represents an employee with the following attributes:
	
		name: The employee's name.
	
		age: The employee's age.
	
		department: The employee's department.
	
		salary: The employee's salary.

EmployeeProcessor Class

	The EmployeeProcessor class contains the main method, which performs the processing tasks.

Author

Liliane Lukong - liliane.haniel@gmail.com

