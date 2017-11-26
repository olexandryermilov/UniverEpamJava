package taxcalculator;

import income.Income;
import taxes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/*
1.	Определить множество и сумму налоговых выплат физического лица за год с учетом доходов с основного
 и дополнительного мест работы, авторских вознаграждений, продажи имущества,
  получения в подарок денежных сумм и имущества, переводов из-за границы, льгот на детей и материальную помощь.
   Провести сортировку налогов по сумме.
 */
public class Calculator {
    private ArrayList<TaxToShow> allTaxesValues;
    public double calculateTaxes(Income income){
        TaxAggregator taxAggregator = new TaxAggregator();
        double sumOfTaxes = 0;
        double taxToPay = taxAggregator.getAuthorTax().getMoneyToPay(income.getAuthorIncome());
        sumOfTaxes+=taxToPay;
        allTaxesValues.add(new TaxToShow("Author tax",taxToPay));

        taxToPay = taxAggregator.getCarTax().getMoneyToPay(income.getAmountOfCars());
        sumOfTaxes+=taxToPay;
        allTaxesValues.add(new TaxToShow("Car tax",taxToPay));

        taxToPay = taxAggregator.getAdditionalIncomeTax().getMoneyToPay(income.getAdditionalIncome());
        sumOfTaxes+=taxToPay;
        allTaxesValues.add(new TaxToShow("Additional income tax",taxToPay));

        taxToPay = taxAggregator.getMainIncomeTax().getMoneyToPay(income.getMainIncome());
        sumOfTaxes+=taxToPay;
        allTaxesValues.add(new TaxToShow("Main income tax",taxToPay));

        taxToPay = taxAggregator.getGiftTax().getMoneyToPay(income.getGiftIncome());
        sumOfTaxes+=taxToPay;
        allTaxesValues.add(new TaxToShow("Gift tax",taxToPay));

        taxToPay = taxAggregator.getRealEstateTax().getMoneyToPay(income.getRealEstateIncome());
        sumOfTaxes+=taxToPay;
        allTaxesValues.add(new TaxToShow("Real estate income tax",taxToPay));

        taxToPay = taxAggregator.getTransferTax().getMoneyToPay(income.getTransferIncome());
        sumOfTaxes+=taxToPay;
        allTaxesValues.add(new TaxToShow("Transfer tax",taxToPay));

        return sumOfTaxes;
    }

    public Calculator() {
        this.allTaxesValues =new ArrayList<>();
    }

    public ArrayList<TaxToShow> getAllTaxesValues() {
        allTaxesValues.sort(Comparator.comparingDouble(TaxToShow::getMoney));
        return allTaxesValues;
    }
}
