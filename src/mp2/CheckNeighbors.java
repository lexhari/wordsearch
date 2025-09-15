package mp2;

public class CheckNeighbors {
  // The CheckNeighbors class is utilized for ease of access in searching for the word in the array

  // checkRight: checks if the word is found in the right direction
  public static void checkRight(char[][] array, int y, int x, String word, int length){
    // Initialize the variables required
    int numCols = array[0].length;

    // The wordcheck array will store the characters that match those of the word
    char[] wordCheck = new char[length];
    wordCheck[0] = array[y][x];

    // First check if the word is still possible to be found in the right direction
    // By adding the x position of the element we are checking and the length of the word, we can compare it to the total number of columns
    // If it is more than the number of columns, the word is impossible to be found to the right of the current element
    if ((x+length) <= numCols){
      // A loop then will try and match the neighbors of the cell to the required letters of the word
      // This loops until the length of the word to be found
      for(int i=0;i<length;i++){
        // The neighbor of the current element is set to a variable
        char rightNeighbor = array[y][x+i];
        // And is compared to the character of the required index in the word
        // If successful, the character is inputted into the array 
        if (rightNeighbor == word.charAt(i)){
          wordCheck[i] = rightNeighbor;
        } else break; // If unsuccessful, the word is impossible to be found, and the loop is broken
      }
    
      // The wordCheck array is then turned into a string, and then compared
      String wordCheckString = new String(wordCheck);
      // If both are equal to each other, the word is found to the right direction of the character at (y,x)
      if (wordCheckString.equals(word)){
        System.out.println(word+" - ("+y+", "+x+"): right");
      }
    
    }
  }

  // checkBottom: checks if the word is found in the bottom direction
  public static void checkBottom(char[][] array, int y, int x, String word, int length){
    // The method functions the same as the checkRight method, but in the bottom direction instead
    int numRows = array.length;
    char[] wordCheck = new char[length];
    wordCheck[0] = array[y][x];

    if ((y+length) <= numRows){
      for(int i=0;i<length;i++){
        char bottomNeighbor = array[y+i][x];
        if (bottomNeighbor == word.charAt(i)){
          wordCheck[i] = bottomNeighbor;
        }
      }
    }

    String wordCheckString = new String(wordCheck);
      if (wordCheckString.equals(word)){
        System.out.println(word+" - ("+y+", "+x+"): down");

  }
  }
}
