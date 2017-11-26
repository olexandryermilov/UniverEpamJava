package taxestest;

import org.junit.Before;
import org.junit.Test;
import taxes.AuthorTax;
import taxes.CarTax;

import static org.junit.Assert.assertTrue;

public class CarTaxTest{
    CarTax carTax;
    @Before
    public void prepareTest(){
        carTax = new CarTax();
    }
    @Test
    public void getMoneyToPay_CalculatesTax_PositiveIncome(){
        final int rightAnswer = 100;
        double answer = carTax.getMoneyToPay(1);
        assertTrue(DoubleComparator.isEqual(rightAnswer,answer));
    }
}
