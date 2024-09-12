# Stock-Analyzer

Overview

The StockAnalyzer program is a Java application designed to perform various analytical operations on stock prices. It demonstrates the use of both arrays and ArrayLists to handle stock data, offering methods to calculate average prices, find maximum prices, count occurrences of specific prices, and compute cumulative sums.

Features

	Calculate Average Price: Computes the average stock price from an array of prices.
	
	Find Maximum Price: Identifies the highest stock price from an array of prices.
	
	Count Occurrences: Counts how many times a specific price appears in an array of prices.
	
	Compute Cumulative Sum: Calculates the cumulative sum of stock prices and stores it in an ArrayList.

Requirements

	Java Development Kit (JDK) 8 or higher.

Usage

	1. Download or clone the repository
 
 			git clone <repository-url>

 	2. Navigate to the directory:

 			cd StockAnalyzer
		
	3. Compile the program

 			javac StockAnalyzer.java
		
	4. Run the program:

 			java StockAnalyzer
		
Explanation

	Imports:
	import java.util.ArrayList; - Importing the ArrayList class for handling dynamic lists.
	
	Class Definition:
	public class StockAnalyzer { - Defining the StockAnalyzer class.
	
	Method: calculateAveragePrice:
	Takes an array of stock prices as input and calculates the average price.
	
	Method: findMaximumPrice:
	Takes an array of stock prices as input and finds the maximum price.
	
	Method: countOccurrences:
	Takes an array of stock prices and a target price as input, returning the count of occurrences of the target price.

	Method: computeCumulativeSum:
	Takes an ArrayList of stock prices as input and returns a new ArrayList with cumulative sums at each position.

Main Method:

	Initializes sample data.
	
	Demonstrates the usage of the above methods by calling them and printing their results.

License

	This project is licensed under the MIT License.

Author

	Liliane Lukong - liliane.haniel@gmail.com

