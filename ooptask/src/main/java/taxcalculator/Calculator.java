package taxcalculator;

import java.util.Scanner;

public class Calculator {
    private static TaxAggregator taxAggregator;
    private static double calculateTaxes(){
        double sumOfTaxes = 0;

        sumOfTaxes+=getMainIncomeTax();
        sumOfTaxes+=getAdditionalIncomeTax();
        sumOfTaxes+=getAuthorTax();
        sumOfTaxes+=getGiftTax();
        sumOfTaxes+=getSoldRealEstateTax();
        sumOfTaxes+=getTranserTax();
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
        return taxAggregator.getMainIncomeTax().getMoneyToPay(readPositiveInteger());
    }
    private static double getAdditionalIncomeTax(){
        System.out.println("Please, enter summary income from your additional sources:");
        return taxAggregator.getAdditionalIncomeTax().getMoneyToPay(readPositiveInteger());
    }
    private static double getAuthorTax(){
        System.out.println("Please, enter your incomes from author works:");
        return taxAggregator.getAuthorTax().getMoneyToPay(readPositiveInteger());
    }
    private static double getCarTax(){
        System.out.println("Please, enter your amount of cars:");
        return readPositiveInteger()*taxAggregator.getCarTax().getValueToPay();
    }
    private static double getGiftTax(){
        System.out.println("Please, enter your sum of gifts:");
        return taxAggregator.getGiftTax().getMoneyToPay(readPositiveInteger());
    }
    private static double getSoldRealEstateTax(){
        System.out.println("Please, enter your income from selling real estate");
        return taxAggregator.getRealEstateTax().getMoneyToPay(readPositiveInteger());
    }
    private static double getTranserTax(){
        System.out.println("Please, enter your income from taxes:");
        return taxAggregator.getTransferTax().getMoneyToPay(readPositiveInteger());
    }
    public static void main(String[] args){
        taxAggregator = new TaxAggregator();
        System.out.println(calculateTaxes());
    }
}
