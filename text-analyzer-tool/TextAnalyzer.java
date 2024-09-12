/**
 * The TextAnalyzer program in Java prompts the user to input a paragraph or a lengthy text, 
 * ensuring the text is at least 100 characters long. It then performs several text analysis tasks: 
 * calculating and displaying the total number of characters and words, identifying and displaying 
 * the most common character (ignoring spaces), and asking the user to input a character to find its 
 * frequency in the text. Additionally, the program prompts the user to enter a word to determine its 
 * frequency and calculates and displays the number of unique words in the text. The text analysis is 
 * case-insensitive for character and word frequency calculations. The program includes input validation 
 * to ensure that the text input is sufficiently lengthy, that the character input is a single character, 
 * and that the word input is at least two characters long and is not an integer.
 */

import java.util.*;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

	  String userInput = "";

        // User Input: Ask the user to input a paragraph or a lengthy text
        while (true) {
            System.out.println("Please enter a paragraph or a lengthy text: ");
            userInput = inputScanner.nextLine().trim();

            if (userInput.length() < 100) {
                System.out.println("Text is too short. Try again.");
            } else {
                break;
            }
	  }

        // Character Count: Calculate and display the total number of characters in the input text
        int charCount = userInput.length();
        System.out.println("Total number of characters: " + charCount);

        // Word Count: Calculate and display the total number of words in the input text
        String[] wordArray = userInput.split("\\s+");
        int wordCount = wordArray.length;
        System.out.println("Total number of words: " + wordCount);

        // Unique Words: Calculate and display the number of unique words in the text (case-insensitive)
        int uniqueWordsCount = calculateUniqueWords(wordArray);
        System.out.println("Number of unique words: " + uniqueWordsCount);

        // Most Common Character: Find and display the most common character in the text
        char mostFrequentChar = findMostFrequentCharacter(userInput);
        System.out.println("Most common character: " + mostFrequentChar);

        // Character Frequency: Ask the user to input a character and display the frequency of occurrences
	  String charInput = "";
	  while (charInput.length() != 1) {
    		System.out.println("Enter a character to find its frequency: ");
    		charInput = inputScanner.nextLine().trim().toLowerCase();

    		if (charInput.length() != 1) {
        		System.out.println("Invalid input. Please enter a single character.");
    		}
	  }

	  char specificChar = charInput.charAt(0);
	  int specificCharFrequency = calculateCharFrequency(userInput, specificChar);
	  System.out.println("Frequency of character '" + specificChar + "': " + specificCharFrequency);


        // Word Frequency: Ask the user to input a word and display the frequency of occurrences
        String wordInput;
        while (true) {
            System.out.println("Enter a word to find its frequency: ");
            wordInput = inputScanner.nextLine().trim().toLowerCase();

            if (wordInput.length() < 2) {
                System.out.println("Word cannot be empty or less than 2. Try again.");
		} else if (wordInput.matches("\\d+")) {
                System.out.println("Word cannot be an integer. Try again.");
            } else {
                break;
            }
        }

        int wordFrequency = calculateWordFrequency(wordArray, wordInput);
        System.out.println("Frequency of word '" + wordInput + "': " + wordFrequency);

        inputScanner.close();
    }


    // Method to find the most common character in the text
    private static char findMostFrequentCharacter(String inputText) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (char character : inputText.toLowerCase().toCharArray()) {
            if (character != ' ') { // ignore spaces
                characterCountMap.put(character, characterCountMap.getOrDefault(character, 0) + 1);
            }
        }
        char mostFrequentCharacter = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentCharacter = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostFrequentCharacter;
    }


    // Method to get the frequency of a specific character in the text (case-insensitive)
    private static int calculateCharFrequency(String inputText, char character) {
        int frequency = 0;
        for (char ch : inputText.toLowerCase().toCharArray()) {
            if (ch == character) {
                frequency++;
            }
        }
        return frequency;
    }

    // Method to get the frequency of a specific word in the text (case-insensitive)
    private static int calculateWordFrequency(String[] wordArray, String word) {
        int frequency = 0;
        for (String w : wordArray) {
            if (w.equalsIgnoreCase(word)) {
                frequency++;
            }
        }
        return frequency;
    }

    // Method to calculate the number of unique words in the text (case-insensitive)
    private static int calculateUniqueWords(String[] wordArray) {
        Set<String> uniqueWordsSet = new HashSet<>();
        for (String word : wordArray) {
            uniqueWordsSet.add(word.toLowerCase());
        }
        return uniqueWordsSet.size();
    }
}
 


