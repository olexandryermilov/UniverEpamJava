package taxcalculator;

import income.Income;
import taxes.*;

import java.util.ArrayList;
import java.util.Scanner;
/*
1.	Определить множество и сумму налоговых выплат физического лица за год с учетом доходов с основного
 и дополнительного мест работы, авторских вознаграждений, продажи имущества,
  получения в подарок денежных сумм и имущества, переводов из-за границы, льгот на детей и материальную помощь.
   Провести сортировку налогов по сумме.
 */
public class Calculator {
    private static TaxAggregator taxAggregator;
    private static ArrayList<Tax> taxes;
    public static double calculateTaxes(Income income){
        double sumOfTaxes = 0;
        taxAggregator=new TaxAggregator();
        for(Tax tax: taxAggregator.getTaxes()){
            if(tax in)
        }
        return sumOfTaxes;
    }
    public static void main(String[] args){
        taxAggregator = new TaxAggregator();
        Income income = new Income();
        System.out.println(calculateTaxes(income));
    }
}
