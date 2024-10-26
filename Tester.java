import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Tester file.
 *
 * Use this main method to test classes and methods as you create them.
 * Feel free to modify this file as you wish.
 */
public class Tester {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(WordBank.checkInDictionary("hello"));  // true
    System.out.println(WordBank.checkInDictionary("asdfg"));  // false

    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(1)); // plumb

    // TODO add tests for Wordle Letter
    WordleLetter letter1 = new WordleLetter('a');
    letter1.setColor("green");
    System.out.println(letter1.isGreen());
    // TODO add tests for Wordle Game

    Scanner scanner = new Scanner(System.in);
    System.out.println("What puzzle number: ");
    int puzzleNumber = scanner.nextInt();

    WordleGame game1 = new WordleGame(WordBank.getAnswerForPuzzleNumber(puzzleNumber));
    game1.guess("hello");
    WordleLetter[][] testArray = game1.getWordleLetterArray();

    for(int i = 0; i < game1.getNumberGuessesSoFar(); i++){
      for(int j = 0; j < testArray[i].length; j++){
      System.out.print(testArray[i][j]);
      }
      System.out.println();
    }
    System.out.println(game1.getAnswer());

    // TODO add tests for Main

  }
}
