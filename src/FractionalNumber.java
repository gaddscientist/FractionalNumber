/**
FractionalNumber.java
Bryan Hilldrup
2/16/19

A class to create and handle Fractional Numbers as a
numerator/denominator pair.
 */

public class FractionalNumber {
    // Instantiates instance variables
    private int numerator;
    private int denominator;

//  Sets default values for numerator & denominator
    public FractionalNumber(){
        numerator = 1;
        denominator = 1;
    }

    /*
        Precondition: denominator cannot be 0
        @param num      the numerator of the fraction
        @param denom    the denominator of the fraction, may not be 0 */
    public FractionalNumber(int num, int denom){
        numerator = num;
        if(denom != 0)
            denominator = denom;
        else
            throw new IllegalArgumentException("Denominator cannot be 0.");
    }

    /*
    *   Adjusts the sign of the numerator and denominator so the
    *   denominator is positive, if necessary */
    public void normalize(){
        int num = this.getNumerator(), denom = this.getDenominator();
        if (this.getNumerator() > 0 && this.getDenominator() < 0){
            num = -1*this.getNumerator();
            denom = Math.abs(getDenominator());
        }
        else if (this.getNumerator() < 0 && this.getDenominator() < 0){
            num = Math.abs(this.getNumerator());
            denom = Math.abs(this.getDenominator());
        }
        this.setNumerator(num);
        this.setDenominator(denom);

    }

    /* Finds the lowest common multiple between two given numbers
       @Param denom1    The denominator of the number to be added to
       @param denom2    The denominator of the number you are adding */
    private static int lowestCommonMultiple(int denom1, int denom2){
        int denominator1 = denom1;
        int denominator2 = denom2;
        int lcm = 0;

        // Finds the greater denominator
        if (denominator1 > denominator2){
            lcm = denominator1;
        }
        else if (denominator2 > denominator1) {
            lcm = denominator2;
        }
        else {
            lcm = denominator1;
        }

        // Increments i until it is a multiple of both denominators
        for (int i = lcm; i < (denominator1 * denominator2); i++){
           if (i % denominator1 == 0 && i % denominator2 == 0) {
               return i;
           }
        }

        // Returns the two denominators multiplied as the lcm if it is
        // not reached in the for loop
        return denominator1 * denominator2;
    }

    /*
    *   Adds the parameter to this fractional number
    *   Precondition: this and otherNum are valid FractionalNumbers
    *   Postcondition: this is the sum of the two fractions
    *   Class Invariant: otherNum is not changed
    *   @param  otherNum    The FractionalNumber to be added */
    public void add(final FractionalNumber otherNum){
        // Gets the lowest common multiple between the two numbers to be added
        int lcm = lowestCommonMultiple(this.denominator, otherNum.denominator);

        // Calculates the new numerator of the two fractions after they are added
        // and sets the calling FractionalNumber's numerator equal to it
        this.setNumerator(((lcm / this.denominator) * this.numerator) +
                ((lcm / otherNum.denominator) * otherNum.numerator));

        // Sets the calling FractionalNumber's denominator equal to the lowest common multiple
        this.setDenominator(lcm);
    }

    /*
     *   Subtracts the parameter from this fractional number
     *   Precondition: this and otherNum are valid FractionalNumbers
     *   Postcondition: this is the difference of the two fractions
     *   Class Invariant: otherNum is not changed
     *   @param  otherNum    The FractionalNumber to be subtracted*/
    public void subtract(final FractionalNumber otherNum){
        // Gets the lowest common multiple between the two numbers to be subtracted
        int lcm = lowestCommonMultiple(this.denominator, otherNum.denominator);

        // Calculates the new numerator of the two fractions after they are subtracted
        // and sets the calling FractionalNumber's numerator equal to it
        this.setNumerator(((lcm / this.denominator) * this.numerator) -
                ((lcm / otherNum.denominator) * otherNum.numerator));

        // Sets the calling FractionalNumber's denominator equal to the lowest common multiple
        this.setDenominator(lcm);
    }

    /*
     *   Multiplies the parameter times this fractional number
     *   Precondition: this and otherNum are valid FractionalNumbers
     *   Postcondition: this is the product of the two fractions
     *   Class Invariant: otherNum is not changed
     *   @param  otherNum    The FractionalNumber to be multiplied*/
    public void multiply(final FractionalNumber otherNum){
        int num = this.getNumerator(), denom = this.getDenominator();

        // Calls getter methods for the two Fractional Numbers' numerators
        // and sets num to their product
        num = this.getNumerator() * otherNum.getNumerator();

        // Calls getter methods for the two Fractional Numbers' denominators
        // and sets denom to their product
        denom = this.getDenominator() * otherNum.getDenominator();

        // Sets the calling objects numerator to num and denominator to denom
        this.setNumerator(num);
        this.setDenominator(denom);
    }

    /*
     *   Multiplies the inverse of the parameter times this fractional number
     *   Precondition: this and otherNum are valid FractionalNumbers
     *   Postcondition: this is the quotient of the two fractions
     *   Class Invariant: otherNum is not changed
     *   @param  otherNum    The FractionalNumber to be divided*/
    public void divide(final FractionalNumber otherNum){
        int num = this.getNumerator(), denom = this.getDenominator();

        // Calls getter methods for the two Fractional Numbers' numerators
        // and sets the calling object's numerator to their product
        num = this.getNumerator() * otherNum.getDenominator();

        // Calls getter methods for the two Fractional Numbers' denominators
        // and sets the calling object's denominator to their product
        denom = this.getDenominator() * otherNum.getNumerator();

        // Sets the calculated numerator and denominator
        this.setNumerator(num);
        this.setDenominator(denom);
    }

    // Returns the numerator of the calling FractionalNumber
    public int getNumerator(){
        return this.numerator;
    }

    // Returns the denominator of the calling FractionalNumber
    public int getDenominator(){
        return this.denominator;
    }

    // Sets the numerator of the calling function to the given integer
    // @param num   the integer to be set
    public void setNumerator(int num){
        numerator = num;
        if(num < 0) denominator = -denominator;

    }

    // Sets the denominator of the calling function to the given integer
    // @param denom     the integer to be set
    public void setDenominator(int denom){
        if(denom == 0) throw new IllegalArgumentException();
        else if(denom < 0) {
            denominator = -denom;
            numerator = -numerator;
        }
        else denominator = denom;
    }

    /*
    *   @return     true if this fraction and other would reduce to the
    *               same numerator and denominator, false otherwise
    *   @param      other       a FractionalNumber  */
    @Override
    public boolean equals(Object other){
        if (this == other) return true; // Checks to see if two objects are the same
        if (other == null) return false; // Checks to see if parameter is null
        if(!(other instanceof FractionalNumber)) return false; // Checks to see if other is a FractionalNumber

        FractionalNumber otherNum = (FractionalNumber) other;
        return numerator * otherNum.getDenominator() == otherNum.getNumerator()
            * denominator;
    }

    /*
     * A method to convert a FractionalNumber to a string
     * @return the FractionalNumber as a string */
    @Override
    public String toString(){
        return (this.getNumerator()+ "/" + this.getDenominator());
    }
}
