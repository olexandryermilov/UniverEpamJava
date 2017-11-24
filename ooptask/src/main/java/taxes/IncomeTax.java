package taxes;

public class IncomeTax extends PercentTax {
    private final static int MAIN_INCOME_PERCENT = 20, ADDITIONAL_INCOME_PERCENT = 5;
    private boolean isMainIncome;
    public IncomeTax(boolean isMainIncome){
        super((isMainIncome)?MAIN_INCOME_PERCENT:ADDITIONAL_INCOME_PERCENT);
        this.isMainIncome=isMainIncome;
    }
}
