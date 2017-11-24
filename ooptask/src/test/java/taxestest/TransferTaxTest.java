package taxestest;

import org.junit.Before;
import org.junit.Test;
import taxes.AuthorTax;
import taxes.GiftTax;
import taxes.TransferTax;

import static org.junit.Assert.assertTrue;

public class TransferTaxTest{
    TransferTax tax;
    @Before
    public void prepareTest(){
        tax = new TransferTax();
    }
    @Test
    public void getMoneyToPay_CalculatesTax_PositiveIncome(){
        final int income = 1000;
        final int rightAnswer = 10;
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
