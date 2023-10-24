import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Maria (original Fraction class was made in collaboration w/ Lydia)
 * @version Sept. 2023 Miniproject 2
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction 
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
    * Convert an integer into a fraction
   */
  public BigFraction(int num){
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(1);
  }
  
  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;

  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   */
  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);

  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   */
  public BigFraction(String str) {
    if(str.length() == 1){
      this.num = new BigInteger(str);
      this.denom = BigInteger.valueOf(1);
    } else{
    String[] numStr = str.split("/");
    this.num = new BigInteger(numStr[0]);
    this.denom = new BigInteger(numStr[1]);
    }

  } // Fraction(String str)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Multiply this fraction with another fraction.
   */
  public BigFraction multiply(BigFraction num1){
    BigInteger resultNumerator = this.num.multiply(num1.num);
    BigInteger resultDenominator = this.denom.multiply(num1.denom);
    return new BigFraction(resultNumerator, resultDenominator);
  } // multiply(Fracton num1)

  /**
   * Identify and return the fractional value of this fraction ias a fraction.
   */
  public BigFraction fractional() {
    BigInteger remain = this.num.remainder(this.denom);
    return new BigFraction(remain, this.denom);
  } // fractional()

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
  * Subtract the fractions
  */
  public BigFraction subtract(BigFraction subMe){
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(subMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(subMe.denom)).subtract(subMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// subtract(Fraction)

  public BigFraction divide(BigFraction divMe){
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(divMe.num);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(divMe.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  /*
   * Simplifies the fraction based on the greatest common denominator
   */
  public String simplify(){
    BigInteger gcd = this.num.gcd(this.denom);

    this.num = num.divide(gcd);
    this.denom = denom.divide(gcd);
    
    if(this.denom.equals(BigInteger.ONE)){
      return this.num.toString();
    }

    return this.num + "/" + this.denom;
  }


} // class Fraction

