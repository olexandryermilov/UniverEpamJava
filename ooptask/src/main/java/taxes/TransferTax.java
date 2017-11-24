package taxes;

public class TransferTax extends PercentTax {
    private final static int TRANSFER_PERCENT = 1;
    public TransferTax(){
        super(TRANSFER_PERCENT);
    }
}
