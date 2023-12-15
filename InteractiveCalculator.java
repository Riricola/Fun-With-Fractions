import java.math.BigInteger;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A calculator that works with fractions, integers, and characters. Repeatedly
 * prompts the user for new expressions to evaluate. Results are always simplified.
 * Ends when the user types "QUIT".
 * 
 * @author Maria 
 * @version Sept. 2023 Miniproject 2
 */
public class InteractiveCalculator{
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calculator = new BFCalculator();
    BigFraction result;

    //Create a scanner that reads input from the terminal
    Scanner scanner = new Scanner(System.in);
    
    //read a user-inputted expression
    String userInput = scanner.nextLine();

    while(! userInput.equals("QUIT")){
      //keep reading lines
      

      if(userInput.length() == 1){
        result = calculator.evaluate(userInput);
        pen.println(result.simplify());

        userInput = scanner.nextLine();
      } //if
      
      //Checks if the user is trying to store a value
       if(userInput.substring(0,5).equals("STORE")){ 
        calculator.store((userInput.substring(6,7)).charAt(0));
        userInput = scanner.nextLine();
      
      } else{ //evaluate and print the result
      result = calculator.evaluate(userInput);
      pen.println(result.simplify());

      userInput = scanner.nextLine();
      } //if
    } //while
    pen.flush();
    scanner.close();
  } //main
} //InteractiveCalculator