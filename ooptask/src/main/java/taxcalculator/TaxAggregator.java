package taxcalculator;

import taxes.*;
import taxes.PercentTax;

import java.util.ArrayList;

public class TaxAggregator {
    private AuthorTax authorTax;
    private CarTax carTax;
    private GiftTax giftTax;
    private IncomeTax mainIncomeTax,additionalIncomeTax;
    private SoldRealEstateTax realEstateTax;
    private TransferTax transferTax;
    public TaxAggregator(){
        authorTax = new AuthorTax();
        carTax = new CarTax();
        giftTax = new GiftTax();
        mainIncomeTax = new IncomeTax(true);
        additionalIncomeTax = new IncomeTax(false);
        realEstateTax = new SoldRealEstateTax();
        transferTax = new TransferTax();
    }
    public AuthorTax getAuthorTax() {
        return authorTax;
    }

    public CarTax getCarTax() {
        return carTax;
    }

    public GiftTax getGiftTax() {
        return giftTax;
    }

    public IncomeTax getMainIncomeTax() {
        return mainIncomeTax;
    }

    public IncomeTax getAdditionalIncomeTax() {
        return additionalIncomeTax;
    }

    public SoldRealEstateTax getRealEstateTax() {
        return realEstateTax;
    }

    public TransferTax getTransferTax() {
        return transferTax;
    }

}
