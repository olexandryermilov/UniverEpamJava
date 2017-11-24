package taxestest;

import org.junit.Before;
import taxcalculator.Calculator;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class CalculatorTest {
    Calculator calc;
    @Before
    public void initCalc(){
        calc = new Calculator();
    }
}
