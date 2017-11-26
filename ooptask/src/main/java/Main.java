import com.sun.org.apache.xpath.internal.SourceTree;
import income.Income;
import taxcalculator.Calculator;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        System.out.println("Tax to pay: "+calculator.calculateTaxes(new Income()));
        System.out.println(calculator.getAllTaxesValues());
    }
}
