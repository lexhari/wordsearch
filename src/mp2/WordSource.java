package mp2;

public class WordSource {
  // The WordSource class is utilized for ease of access in the word's length, first letter, and word length

  // Set variables
  private String word;
  private char firstLetter;
  private int wordLength;

  // Constructor
  public WordSource(String word, char firstLetter, int wordLength){
    this.word = word;
    this.firstLetter = firstLetter;
    this.wordLength = wordLength;
  }

  // Getters and Setters

  public String getWord() {
    return word;
  }

  public char getFirstLetter() {
    return firstLetter;
  }
  
  public int getWordLength() {
    return wordLength;
  }
  
  public void setWord(String word) {
    this.word = word;
  }
  
  public void setWordLength(int wordLength) {
    this.wordLength = wordLength;
  }

  public void setFirstLetter(char firstLetter) {
    this.firstLetter = firstLetter;
  }
}
