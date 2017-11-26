package taxcalculator;

import taxes.*;
import taxes.PercentTax;

import java.util.ArrayList;

public class TaxAggregator {

    private ArrayList<Tax>taxes;
    public TaxAggregator(){
        taxes.add(new AuthorTax());
        taxes.add(new CarTax());
        taxes.add(new GiftTax());
        taxes.add(new IncomeTax(true));
        taxes.add(new IncomeTax(false));
        taxes.add(new SoldRealEstateTax());
        taxes.add(new TransferTax());
    }
    public ArrayList<Tax> getTaxes() {
        return taxes;
    }
    public void addTax(Tax tax){
        taxes.add(tax);
    }

}
