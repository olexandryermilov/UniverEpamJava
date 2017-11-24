package taxes;

public class SoldRealEstateTax extends PercentTax {
    private final static int REAL_ESTATE_PERCENT=1;
    public SoldRealEstateTax(){
        super(REAL_ESTATE_PERCENT);
    }
}
