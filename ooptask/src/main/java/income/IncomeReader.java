package income;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class IncomeReader {
    private static int readPositiveInteger(InputStream is){
        Scanner in = new Scanner(is);
        int value = -1;
        while(value<0){
            value=in.nextInt();
            if(value<0) System.out.println("Please, enter positive integer");
        }
        return value;
    }
    public Income read(){
        return this.read(System.in);
    }
    public Income read(File file) throws FileNotFoundException {
        return this.read(new FileInputStream(file));
    }
    public Income read(InputStream is){
        int mainIncome,additionalIncome,authorIncome,amountOfCars,giftIncome,realEstateIncome,transferIncome;
        System.out.println("Please, enter your main income:");
        mainIncome = readPositiveInteger(is);
        System.out.println("Please, enter summary income from your additional sources:");
        additionalIncome = readPositiveInteger(is);
        System.out.println("Please, enter your incomes from author works:");
        authorIncome = readPositiveInteger(is);
        System.out.println("Please, enter your amount of cars:");
        amountOfCars = readPositiveInteger(is);
        System.out.println("Please, enter your sum of gifts:");
        giftIncome = readPositiveInteger(is);
        System.out.println("Please, enter your income from selling real estate");
        realEstateIncome = readPositiveInteger(is);
        System.out.println("Please, enter your income from transfers:");
        transferIncome = readPositiveInteger(is);
        return new Income(mainIncome,additionalIncome,authorIncome,amountOfCars,giftIncome,realEstateIncome,transferIncome);
    }
}
