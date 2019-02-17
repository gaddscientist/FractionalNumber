import static org.junit.Assert.*;

/**
 * FractionalNumberTest.java
 * Bryan Hilldrup
 * 2/16/19
 *
 * A class to test the FractionalNumber class for accuracy
 */
public class FractionalNumberTest {
    // Instantiates instance variables
    private FractionalNumber num1;
    private FractionalNumber num2;
    private FractionalNumber numNegNum;
    private FractionalNumber numNegNum2;
    private FractionalNumber numNegDenom;
    private FractionalNumber numNegNumDenom;
    private FractionalNumber numZeroNumPosDenom;
    private FractionalNumber numZeroNumNegDenom;
    private FractionalNumber numBool1;
    private FractionalNumber numBool2;
    private String numeratorString;
    private String denominatorString;

    // Method to be executed before tests
    // Declares instance variables
    @org.junit.Before
    public void setUp() throws Exception {
        num1 = new FractionalNumber(1, 2);
        num2 = new FractionalNumber(1, 4);
        numNegNum = new FractionalNumber(-3, 8);
        numNegNum2 = new FractionalNumber(-2, 8);
        numNegDenom = new FractionalNumber(6, -7);
        numNegNumDenom = new FractionalNumber(-5, -8);
        numZeroNumPosDenom = new FractionalNumber(0, 1);
        numZeroNumNegDenom = new FractionalNumber(0, -1);
        numBool1 = new FractionalNumber(2, 3);
        numBool2 = new FractionalNumber(2, 3);
        numeratorString = "1";
        denominatorString = "4";
    }

    // Tests normalizing a FractionalNumber with a negative
    // numerator and a positive denominator
    @org.junit.Test
    public void normalizeNegativeNumeratorPositiveDenominatorTest() throws Exception {
        FractionalNumber num3 = new FractionalNumber(-3, 8);
        numNegNum.normalize();
        assertEquals("FractionalNumber should be ",  num3, numNegNum);
    }

    // Tests normalizing a FractionalNumber with a positive
    // numerator and a negative denominator
    @org.junit.Test
    public void normalizePositiveNumeratorNegativeDenominatorTest() throws Exception {
        FractionalNumber num3 = new FractionalNumber(-6, 7);
        numNegDenom.normalize();
        assertEquals("FractionalNumber should be ", num3, numNegDenom);
    }

    // Tests normalizing a FractionalNumber with a positive
    // numerator and a positive denominator
    @org.junit.Test
    public void normalizePositiveNumeratorPositiveDenominatorTest() throws Exception {
        FractionalNumber num3 = new FractionalNumber(1, 4);
        num2.normalize();
        assertEquals("FractionalNumber should be ", num3, num2);
    }

    // Tests normalizing a FractionalNumber with a negative
    // numerator and a negative denominator
    @org.junit.Test
    public void normalizeNegativeNumeratorNegativeDenominatorTest() throws Exception {
        FractionalNumber num3 = new FractionalNumber(5, 8);
        numNegNumDenom.normalize();
        assertEquals("FractionalNumber should be ", num3, numNegNumDenom);
    }

    // Tests normalizing a FractionalNumber with a zero
    // numerator and a positive denominator
    @org.junit.Test
    public void normalizeZeroNumeratorPositiveDenominatorTest() throws Exception {
        FractionalNumber num3 = new FractionalNumber(0, 1);
        numZeroNumPosDenom.normalize();
        assertEquals("FractionalNumber should be ", num3, numZeroNumPosDenom);
    }

    // Tests normalizing a FractionalNumber with a zero
    // numerator and a negative denominator
    @org.junit.Test
    public void normalizeZeroNumeratorNegativeDenominatorTest() throws Exception {
        FractionalNumber num3 = new FractionalNumber(0, -1);
        numZeroNumNegDenom.normalize();
        assertEquals("FractionalNumber should be ", num3, numZeroNumNegDenom);
    }

    // Tests adding a positive FractionalNumber to a positive FractionalNumber
    @org.junit.Test
    public void additionPositiveFractionPositiveFractionTest() throws Exception {
        num1.normalize(); num2.normalize();
        num1.add(num2);
        FractionalNumber num3 = new FractionalNumber(3, 4);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests adding a positive FractionalNumber to a negative FractionalNumber
    @org.junit.Test
    public void additionPositiveFractionNegativeFractionTest() throws Exception {
        num1.normalize(); numNegNum.normalize();
        num1.add(numNegNum);
        FractionalNumber num3 = new FractionalNumber(1, 8);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests adding a negative FractionalNumber to a positive FractionalNumber
    @org.junit.Test
    public void additionNegativeFractionPositiveFractionTest() throws Exception {
        num1.normalize(); numNegNum.normalize();
        numNegNum.add(num1);
        FractionalNumber num3 = new FractionalNumber(1, 8);
        assertEquals("FractionalNumber should be ", num3, numNegNum);
    }

    // Tests adding a negative FractionalNumber to a negative FractionalNumber
    @org.junit.Test
    public void additionNegativeFractionNegativeFractionTest() throws Exception {
        numNegNum.normalize();
        numNegNum.add(numNegNum);
        FractionalNumber num3 = new FractionalNumber(-6, 8);
        assertEquals("FractionalNumber should be ", num3, numNegNum);
    }

    // Tests subtracting a positive FractionalNumber from a negative FractionalNumber
    @org.junit.Test
    public void subtractionPositiveFractionPositiveFractionTest() throws Exception {
        num1.normalize(); num2.normalize();
        num1.subtract(num2);
        FractionalNumber num3 = new FractionalNumber(1, 4);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests subtracting a positive FractionalNumber from a negative FractionalNumber
    @org.junit.Test
    public void subtractionPositiveFractionNegativeFractionTest() throws Exception {
        num1.normalize(); numNegNum.normalize();
        numNegNum.subtract(num1);
        FractionalNumber num3 = new FractionalNumber(-7, 8);
        assertEquals("FractionalNumber should be ", num3, numNegNum);
    }

    // Tests subtracting a negative FractionalNumber from a positive FractionalNumber
    @org.junit.Test
    public void subtractionNegativeFractionPositiveFractionTest() throws Exception {
        num1.normalize(); numNegNum.normalize();
        num1.subtract(numNegNum);
        FractionalNumber num3 = new FractionalNumber(7, 8);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests subtracting a negative FractionalNumber from a negative FractionalNumber
    @org.junit.Test
    public void subtractionNegativeFractionNegativeFractionTest() throws Exception {
        numNegNum.normalize();
        numNegNum.subtract(numNegNum);
        FractionalNumber num3 = new FractionalNumber(0, 8);
        assertEquals("FractionalNumber should be ", num3, numNegNum);
    }

    // Tests multiplying a positive FractionalNumber by a positive FractionalNumber
    @org.junit.Test
    public void multiplicationPositiveFractionPositiveFractionTest() throws Exception {
        num1.normalize(); num2.normalize();
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(1, 8);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests multiplying a positive FractionalNumber by a negative FractionalNumber
    @org.junit.Test
    public void multiplicationPositiveFractionNegativeFractionTest() throws Exception {
        num1.normalize(); numNegNum.normalize();
        num1.multiply(numNegNum);
        FractionalNumber num3 = new FractionalNumber(-3, 16);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests multiplying a positive FractionalNumber by a negative FractionalNumber
    @org.junit.Test
    public void multiplicationNegativeFractionPositiveFractionTest() throws Exception {
        num1.normalize(); numNegNum.normalize();
        numNegNum.multiply(num1);
        FractionalNumber num3 = new FractionalNumber(-3, 16);
        assertEquals("FractionalNumber should be ", num3, numNegNum);
    }

    // Tests multiplying a negative FractionalNumber by a negative FractionalNumber
    @org.junit.Test
    public void multiplicationNegativeFractionNegativeFractionTest() throws Exception {
        numNegNum.normalize();
        numNegNum.multiply(numNegNum);
        FractionalNumber num3 = new FractionalNumber(9, 64);
        assertEquals("FractionalNumber should be ", num3, numNegNum);
    }

    // Tests dividing a positive FractionalNumber by a positive FractionalNumber
    @org.junit.Test
    public void divisionPositiveFractionPositiveFractionTest() throws Exception {
        num1.normalize(); num2.normalize();
        num1.divide(num2);
        FractionalNumber num3 = new FractionalNumber(2, 1);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests dividing a positive FractionalNumber by a positive FractionalNumber
    @org.junit.Test
    public void divisionPositiveFractionNegativeFractionTest() throws Exception {
        num1.normalize(); numNegNum2.normalize();
        num1.divide(numNegNum2);
        FractionalNumber num3 = new FractionalNumber(-2, 1);
        assertEquals("FractionalNumber should be ", num3, num1);
    }

    // Tests dividing a positive FractionalNumber by a positive FractionalNumber
    @org.junit.Test
    public void divisionNegativeFractionPositiveFractionTest() throws Exception {
        num1.normalize(); numNegNum2.normalize();
        numNegNum2.divide(num1);
        FractionalNumber num3 = new FractionalNumber(-1, 2);
        assertEquals("FractionalNumber should be ", num3, numNegNum2);
    }

    // Tests dividing a positive FractionalNumber by a positive FractionalNumber
    @org.junit.Test
    public void divisionNegativeFractionNegativeFractionTest() throws Exception {
        numNegNum2.normalize();
        numNegNum2.divide(numNegNum2);
        FractionalNumber num3 = new FractionalNumber(1, 1);
        assertEquals("FractionalNumber should be ", num3, numNegNum2);
    }

    // Tests setting the denomitor when it is zero
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void setDenominatorZeroTest() throws Exception {
        num1.normalize();
        num1.setDenominator(0);
    }

    // Tests setting the denomitor to a positive number
    @org.junit.Test
    public void setDenominatorPositiveTest() throws Exception {
        num1.normalize();
        num1.setDenominator(9);
        assertEquals("Denominator should be ", 9, num1.getDenominator());
        num1.setDenominator(3);
        assertEquals("Denominator should be ", 3, num1.getDenominator());
    }

    // Tests setting the denominator to a negative number
    @org.junit.Test
    public void setDenominatorNegativeTest() throws Exception {
        num1.normalize();
        num1.setDenominator(-9);
        assertEquals("Denominator should be ", 9, num1.getDenominator());
        num1.setDenominator(-3);
        assertEquals("Denominator should be ", 3, num1.getDenominator());
    }

    // Tests setting the denominator to a negative when the numerator is positive
    @org.junit.Test
    public void setDenominatorNegativeNumeratorPositiveTest() throws Exception {
        num1.normalize();
        num1.setDenominator(-10);
        assertEquals("Denominator should be ", 10, num1.getDenominator());
        assertEquals("Numerator should be ", -1, num1.getNumerator());
    }

    // Tests setting the denominator to a negative number when the numerator is negative
    @org.junit.Test
    public void setDenominatorNegativeNumeratorNegativeTest() throws Exception {
        numNegNum.normalize();
        numNegNum.setDenominator(-10);
        assertEquals("Denominator should be ", 10, numNegNum.getDenominator());
        assertEquals("Numerator should be ", 3, numNegNum.getNumerator());
    }

    // Tests settings the numerator zero
    @org.junit.Test
    public void setNumeratorZero() throws Exception {
        num1.normalize();
        num1.setNumerator(0);
        assertEquals("Numerator should be ", 0, num1.getNumerator());
    }

    // Tests settings the numerator to a positive number
    @org.junit.Test
    public void setNumeratorPositive() throws Exception {
        num1.normalize();
        num1.setNumerator(8);
        assertEquals("Numerator should be ", 8, num1.getNumerator());
    }

    // Tests settings the numerator to a negative number when the denominator is positive
    @org.junit.Test
    public void setNumeratorNegativeDenominatorPositive() throws Exception {
        num1.normalize();
        num1.setNumerator(-1);
        assertEquals("Numerator should be ", -1, num1.getNumerator());
    }

    // Tests settings the numerator to a negative number when the denominator is negative
    @org.junit.Test
    public void setNumeratorNegativeDenominatorNegative() throws Exception {
        numNegDenom.normalize();
        numNegDenom.setNumerator(-3);
        numNegDenom.normalize();
        assertEquals("Numerator should be ", 3, numNegDenom.getNumerator());
    }

    // Tests if one FractionalNumber is equal to another FractionalNumber
    @org.junit.Test
    public void equalsTest() throws Exception {
        assertTrue(numBool1.equals(numBool2));
    }

    // Tests if the FractionalNumber calling the toString() method is
    // returned as a string
    @org.junit.Test
    public void toStringTest() throws Exception {
        assertEquals(numeratorString + "/" + denominatorString, num2.toString());

    }
}
