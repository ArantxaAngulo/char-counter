package def;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class CharCounter {
	public static void main(String[] args) {
		
		// Input data through a dialog box
        String ArrayLen = JOptionPane.showInputDialog(null, "Enter the number of words you would like to enter", "Character Counter", JOptionPane.QUESTION_MESSAGE);
        int iArrayLen = Integer.parseInt(ArrayLen); //convert user input to integer
        
        String inputArray[] = new String[iArrayLen]; //Creating a String array with variable length (iArrayLen)
        
        // Populating array with user input
        for (int i = 0; i < iArrayLen; i++) {
        	inputArray[i]  = JOptionPane.showInputDialog(null, "Enter a word: ", "Data Input", JOptionPane.QUESTION_MESSAGE); //iterates iArrayLen times to get user input
        }
        //Prints inputArray
        for (int i = 0; i < iArrayLen; i++) {
            System.out.println(inputArray[i] + " ");
        }
        
        //HashMap creation, will consist of chars and integers 
        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();

        // Initialize HashMap with all keys to lower case letters, and every value to 0 
        for (char ch = 'a'; ch <= 'z'; ch++) {
            letterCount.put(ch, 0);
        }

        // Counts occurrences of each lower case letter
        for (String word : inputArray) { //For every "word" in inputArray 
            for (char ch : word.toCharArray()) { // For every character of every word in inputArray
                if (Character.isLowerCase(ch)) {  // Verify if it is lower case
                    letterCount.put(ch, letterCount.get(ch) + 1);  // If found, increment value in HashMap
                }
            }
        }

        int result[] = new int[26]; //Creation of array of integers to print the value of HashMap (which is made up of integers)
        
        for (int k = 0; k < 26; k++) { 
            char ch = (char) ('a' + k); //Sets what to retrieve (see next line) and adds 1 each iteration, ensuring we will go thru all HashMap
            result[k] = letterCount.get(ch);  // Retrieves and saves count/value of each character in HashMap
        }

        // Prints results
        for (int count : result) {
            System.out.print(count + " ");
        }
}
}
