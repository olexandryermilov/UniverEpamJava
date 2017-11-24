package taxestest;

import org.junit.Before;
import org.junit.Test;
import taxes.AuthorTax;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthorTaxTest{
    AuthorTax authorTax;
    @Before
    public void prepareTest(){
        authorTax = new AuthorTax();
    }
    @Test
    public void getMoneyToPay_CalculatesTax_PositiveIncome(){
        final int income = 1000;
        final int rightAnswer = 70;
        double answer = authorTax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
    @Test
    public void getMoneyToPay_CalculatesTax_ZeroIncome(){
        final int income = 0;
        final int rightAnswer = 0;
        double answer = authorTax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
}
