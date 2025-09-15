package mp2;

import java.util.ArrayList;
import java.util.Scanner;

public class FileHandlingMethods {
	
	public void getData(Scanner scanner, ArrayList<Character> arrayList) throws CustomExceptions {

		int charCount = 0;
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine(); // stores data of line in variable line
			charCount++; // number of characters scanned
			if (line.length() == 1) { // if string length of data is 1
				char entry = line.charAt(0); // character is stored in variable entry
				
				if (!Character.isLetter(entry)) { // error handling: line contains different data type
					throw new CustomExceptions("file contains invalid data type in line " + charCount);
				} else if (!Character.isUpperCase(entry)){ // error handling: line contains lowecase character
					throw new CustomExceptions ("file contains lowecase character in line " + charCount);
				}
				
				arrayList.add(entry); // data stored in entry is added to arraylist
			} else if (line.length() == 0) { // if string length is 0
				throw new CustomExceptions("file contains null data in line " + charCount); // error handling: line is empty
			} else { // if string length is more than 1 and 0
				throw new CustomExceptions("file contains more than one character in line " + charCount +" '" + line + "'"); // error handling: line contains more than one character
			}
		}
		
		if (charCount != 64){ // if charCount is not 64
			throw new CustomExceptions("file contains " + charCount + " characters\nArray requires 64 characters"); // error handling: file does not contain 64 characters
		}
	}

	// convert arraylist to 2d array method
	public char[][] convertTo2DArray(ArrayList<Character> list) {
		char[][] array = new char[8][8]; // make array of 8x8 size
		int listIndex = 0;

		// traverse through array
		for (int i = 0; i < 8; i++) { // each row
			for (int j = 0; j < 8; j++) { // each element (column) in row
				array[i][j] = list.get(listIndex); // element of current position in array is set as the element at list's current index
				listIndex++;
			}
		}

		return array;
	}
	
	// display 2D array in 8x8 manner
	public void displayData(char[][] array) {
		for (char[] row : array) {
			for (char data : row) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}
}
