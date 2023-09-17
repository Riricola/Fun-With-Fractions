import java.math.BigInteger;

/**
 * A calculator that works with fractions, integers, and characters. It has 2 methods.
 * An evaluate method, that performs math based on the expression it is given, and 
 * the store method, which stores the most recent result in the calculator's memory.
 * Store sets a result to a character. Results are always simplified.
 * 
 * @author Samuel A. Rebelsky
 * @author Maria (original Fraction class was made in collaboration w/ Lydia)
 * @version Sept. 2023 Miniproject 2
 */
public class BFCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  //Saves the most recent result in it's memory
  BigFraction currentResult;

  //This is the array we will be using to store multiple BigFractions
  BigFraction[] register = new BigFraction[26];

  // +--------+-------------------------------------------------------
  // | Methods |
  // +--------+

  //calculator.evaluate(String exp)
  //Takes in an expression and calculates the result
  public BigFraction evaluate(String exp){
    BigFraction f1;
    BigFraction f2;
    int base = 97;

    //splits the string based on white space
    String[] expStr = exp.split(" ");

    //loops through that checks if the exp has characters and if so
    //search thru register to find the character and associated value,
    //replacing the character with a BigFraction
    for(int i = 0; i < expStr.length; i++){ 
      String temp = expStr[i];

      //Kevin informed me of the .codePointAt() method and I figured out how to apply it here
      if((temp.codePointAt(0) >96) && (temp.codePointAt(0) < 123)){
        expStr[i] = register[(temp.codePointAt(0)) - base].toString();
      }//if
    }//for
    
    //sets f1 equal to the first number
    f1 = new BigFraction(expStr[0]); 

    for(int i = 1; i < (expStr.length - 1); i+= 2){
      //saves the operation
      String operation = expStr[i];
      //saves the second fraction
      f2 = new BigFraction(expStr[i+1]);

      //performs the appropriate operation
      if(operation.equals("+")){
        this.currentResult = f1.add(f2);
      } else if(operation.equals("-")){
        this.currentResult = f1.subtract(f2);
      } else if(operation.equals("*")){
        this.currentResult = f1.multiply(f2);
      } else if(operation.equals("/")){
        this.currentResult = f1.divide(f2);
      }//if

      //saves the result into the first fraction, properly closing the loop
      f1 = this.currentResult;
    }//for

    return this.currentResult;
  }//evaluate()
  

  // calculator.store(char reg)
  // Stores the most recent result to a user specified character, saving the number
  // in the calculator's internal memory.
  public BigFraction store(char reg){
    int base = 97;
    int index = ((int) reg - base);
    //this uses the character's associated number to access the
    //correct BigFraction associated to that letter

    register[index] = this.currentResult;
    //stores the result in the register
    return register[index];
  }//store()
}//BFCalculator 