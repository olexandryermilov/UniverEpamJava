package taxcalculator;

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
    private static double calculateTaxes(){
        double sumOfTaxes = 0;
        taxes = new ArrayList<Tax>();
        sumOfTaxes+=getMainIncomeTax();
        sumOfTaxes+=getAdditionalIncomeTax();
        sumOfTaxes+=getAuthorTax();
        sumOfTaxes+=getGiftTax();
        sumOfTaxes+=getSoldRealEstateTax();
        sumOfTaxes+=getTransferTax();
        sumOfTaxes+=getCarTax();
        return sumOfTaxes;
    }
    private static int readPositiveInteger(){
        Scanner in = new Scanner(System.in);
        int value = -1;
        while(value<0){
            value=in.nextInt();
        }
        return value;
    }
    private static double getMainIncomeTax(){
        System.out.println("Please, enter your main income:");
        Tax tax = taxAggregator.getMainIncomeTax();
        taxes.add(tax);
        return ((IncomeTax)tax).getMoneyToPay(readPositiveInteger());
    }
    private static double getAdditionalIncomeTax(){
        System.out.println("Please, enter summary income from your additional sources:");
        Tax tax = taxAggregator.getAdditionalIncomeTax();
        taxes.add(tax);
        return ((IncomeTax)tax).getMoneyToPay(readPositiveInteger());
    }
    private static double getAuthorTax(){
        System.out.println("Please, enter your incomes from author works:");
        Tax tax = taxAggregator.getAuthorTax();
        taxes.add(tax);
        return ((AuthorTax)tax).getMoneyToPay(readPositiveInteger());
    }
    private static double getCarTax(){
        System.out.println("Please, enter your amount of cars:");
        Tax tax = taxAggregator.getCarTax();
        taxes.add(tax);
        return readPositiveInteger()*((CarTax)tax).getValueToPay();
    }
    private static double getGiftTax(){
        System.out.println("Please, enter your sum of gifts:");
        Tax tax = taxAggregator.getGiftTax();
        taxes.add(tax);
        return ((GiftTax)tax).getMoneyToPay(readPositiveInteger());
    }
    private static double getSoldRealEstateTax(){
        System.out.println("Please, enter your income from selling real estate");
        return taxAggregator.getRealEstateTax().getMoneyToPay(readPositiveInteger());
    }
    private static double getTransferTax(){
        System.out.println("Please, enter your income from taxes:");
        return taxAggregator.getTransferTax().getMoneyToPay(readPositiveInteger());
    }
    public static void main(String[] args){
        taxAggregator = new TaxAggregator();
        System.out.println(calculateTaxes());
    }
}
