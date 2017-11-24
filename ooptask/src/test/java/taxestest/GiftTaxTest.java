package taxestest;

import org.junit.Before;
import org.junit.Test;
import taxes.AuthorTax;
import taxes.GiftTax;

import static org.junit.Assert.assertTrue;

public class GiftTaxTest {
    GiftTax tax;
    @Before
    public void prepareTest(){
        tax = new GiftTax();
    }
    @Test
    public void getMoneyToPay_CalculatesTax_PositiveIncome(){
        final int income = 1000;
        final int rightAnswer = 20;
        double answer = tax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
    @Test
    public void getMoneyToPay_CalculatesTax_ZeroIncome(){
        final int income = 0;
        final int rightAnswer = 0;
        double answer = tax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
}
