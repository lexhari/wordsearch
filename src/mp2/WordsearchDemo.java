package mp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordsearchDemo{

	public static void main(String[] args) {

		// The words provided from the specifications are initialized in the array
		String wordSource[] = {"RIPPLE", "EVE", "FILL", "WHITE", "BREED", "GEL", "DOLL", "LAPEL", "HELP", "PEN", "LACE", "SCRAPE", "RAID", "TEA"};

		// Create the array of type WordSource class 
		WordSource[] words = new WordSource[wordSource.length];

		// Use a for loop to create all the classes
			for(int i=0;i<wordSource.length;i++){
				words[i] = new WordSource(wordSource[i], wordSource[i].charAt(0), wordSource[i].length());
			}

		// make arraylist for the grid of word search puzzle
		ArrayList<Character> wordsearchContent = new ArrayList<Character>();
		// instance of FileHandlingMethods
		FileHandlingMethods makeGrid = new FileHandlingMethods();
		// load up .txt file of letters
		File file = new File("INSERT PATH HERE", "readme.txt");
		
		//file handling
		try {
			// read file
			Scanner sc = new Scanner(file);
			
			// store each character to an arraylist
			makeGrid.getData(sc, wordsearchContent);
			
			// convert arraylist to 2d array
			char[][] wordsearchGrid = makeGrid.convertTo2DArray(wordsearchContent);
				
			// display the array
			makeGrid.displayData(wordsearchGrid);
			sc.close();

			System.out.println("\nDetected words:");
		// Search the array for the words
		// k is the index of the words array, or the words to be found
		// i is the y value in the array
		// j is the x value in the array
		for (int k=0;k<words.length;k++){
			for(int i=0;i<wordsearchGrid.length;i++){
				for(int j=0;j<wordsearchGrid.length;j++){
					// Check if the character in the array is the same as the word's first letter
					// If so, attempt to find the word through the right and bottom directions
					if(wordsearchGrid[i][j]==words[k].getFirstLetter()){
						CheckNeighbors.checkRight(wordsearchGrid, i, j, words[k].getWord(), words[k].getWordLength());
						CheckNeighbors.checkBottom(wordsearchGrid, i, j, words[k].getWord(), words[k].getWordLength());
					}
				}
			}
		}
		
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND: " + e.getMessage());
		} catch (CustomExceptions e){
			// possible errors:
			// line contains different data type
			// line contains lowercase character
			// line is empty
			// line contains more than one character
			// file does not contain 64 characters
			System.out.println("INVALID DATA: " + e.getMessage());
		} finally {
			System.out.println("\nEND");
		}
	}
}

