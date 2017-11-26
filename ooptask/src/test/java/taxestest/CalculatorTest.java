package taxestest;

import income.Income;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import taxcalculator.Calculator;
import taxcalculator.TaxToShow;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    private static Calculator calc;
    private static Income income;
    @BeforeClass
    public static void initCalc(){
        calc = new Calculator();
    }
    @BeforeClass
    public static void initIncome(){
        income = new Income(1,1,1,1,1,1,1);
    }
    @Test
    public void Calculator_GivesRightTax(){
        final double RIGHT_ANSWER = 100.36;
        double answer = calc.calculateTaxes(income);
        assertTrue(DoubleComparator.isEqual(RIGHT_ANSWER,answer));
    }
    @Test
    public void Calculator_SortsTaxes(){
        boolean isSorted = true;
        calc.calculateTaxes(income);
        ArrayList<TaxToShow> taxesToShow = calc.getAllTaxesValues();
        for(int i=1;i<taxesToShow.size();i++){
            if(!(taxesToShow.get(i).getMoney()>=taxesToShow.get(i-1).getMoney())){
                isSorted=false;
                break;
            }
        }
        assertTrue(isSorted);
    }
}
