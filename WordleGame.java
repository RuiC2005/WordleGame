public class WordleGame {
  // TODO - implement according to spec
  private WordleLetter[][] game = new WordleLetter[6][5];
  //this initializes a 2d array
  private String answer;
  private int guesses = 0;

  // TODO - include the remainder of the below code back in once rest of class is implemented.
  // Do not modify this method implementation.
  public WordleGame(String puzzleAnswer){
    this.answer = puzzleAnswer;
  }

  public void guess(String guessWord){
    for(int i = 0; i < 5; i++){
      this.game[this.guesses][i] = new WordleLetter(guessWord.charAt(i));
      //this initializes and populates the 2d array in the row according with the guess.

    for(int j=0; j<5; j++){
      if(this.game[this.guesses][i].getLetter() == this.answer.charAt(j)){
        //the purpose of this loop is to compare each character from the guessed word to each character in the answer word.
            this.game[this.guesses][i].setColor("yellow");
            break;
            // if a letter matches in any location in the answer it assigns yellow and stops the loop
          }
          else{
            this.game[this.guesses][i].setColor("red");
            //this will leave the character red if no matches are found
          }
      }
      if(this.game[this.guesses][i].getLetter() == this.answer.charAt(i)){
        this.game[this.guesses][i].setColor("green");
        //this will check if the character matches the answer at the SAME position
      }

    }

    this.guesses++;
  }

  public WordleLetter[] getGuess(int guessNumber){
    return game[guessNumber];
  }

  public String getAnswer(){
    return answer;
  }

  public boolean isGameOver(){
    if(isGameWin() || this.guesses == 6){
      return true;
    }
    return false;
  }

  public boolean isGameWin(){
    if(this.guesses == 0){
      return false;
    }
    //this is because there is no need to check if the number of guesses are 0

    for(int i = 0; i < 5; i++){
      if(!this.game[this.guesses-1][i].isGreen()){
        return false;
      }

      //the moment that a character is not green in a guess, it means the word is not guessed yet.
      }
      return true;
}
  public WordleLetter[][] getWordleLetterArray(){
    return this.game;
  }

  public int getNumberGuessesSoFar(){
    return guesses;
  }

  public String toString() {
    // result will be used to build the full answer String
    String result = "";
    // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      // get each letter of each word
      for (int j = 0; j < 5; j++) {
        // concatenate it to the result
        // WordleLetter's toString() is automatically invoked here.
        result += getGuess(i)[j];
      }
      // new line separator between each word
      result += "\n";
    }
    return result;
  }
}
