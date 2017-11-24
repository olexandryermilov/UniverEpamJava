package taxestest;

import org.junit.Before;
import org.junit.Test;
import taxes.GiftTax;
import taxes.IncomeTax;

import static org.junit.Assert.assertTrue;

public class IncomeTaxTest  {
    private final static int MAIN_INCOME_PERCENT = 20, ADDITIONAL_INCOME_PERCENT = 5;
    IncomeTax mainTax,additionalTax;
    @Before
    public void prepareTest(){
        mainTax = new IncomeTax(true);
        additionalTax = new IncomeTax(false);
    }
    @Test
    public void getMoneyToPay_CalculatesMainTax_PositiveIncome(){
        final int income = 1000;
        final int rightAnswer = 200;
        double answer = mainTax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
    @Test
    public void getMoneyToPay_CalculatesMainTax_ZeroIncome(){
        final int income = 0;
        final int rightAnswer = 0;
        double answer = mainTax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
    @Test
    public void getMoneyToPay_CalculatesAdditionalTax_PositiveIncome(){
        final int income = 1000;
        final int rightAnswer = 50;
        double answer = additionalTax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
    @Test
    public void getMoneyToPay_CalculatesAdditionalTax_ZeroIncome(){
        final int income = 0;
        final int rightAnswer = 0;
        double answer = additionalTax.getMoneyToPay(income);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
}
