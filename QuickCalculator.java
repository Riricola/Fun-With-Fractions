import java.math.BigInteger;
import java.io.PrintWriter;
/**
 * A calculator that works with fractions, integers, and characters. 
 * Takes expressions from the command line, each separated by quotation marks.
 * Results are always simplified.
 * 
 * @author Maria 
 * @version Sept. 2023 Miniproject 2
 */
public class QuickCalculator{
  public static void main(String[] args) throws Exception{

    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calculator = new BFCalculator();
    BigFraction result;


      /* Here is where I would add code to make sure it takes unfinished expressions
      for(int i =0; i< expression.length; i++){
        if
      }
      if(expression == 1){
        */

        result = calculator.evaluate(expression);
        pen.println(result.simplify());

      } else if(expression.substring(0,5).equals("STORE")){ 
        calculator.store((expression.substring(6,7)).charAt(0));
      } else{
      //print the result
      result = calculator.evaluate(expression);
      pen.println(args[i] + " = " + result.simplify());
      }//if
    }//for
    pen.flush();

  }//main
} //QuickCalculator