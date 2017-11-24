package taxes;

public class GiftTax extends PercentTax {
    private final static int GIFT_PERCENT =2;
    public GiftTax() {
        super(GIFT_PERCENT);
    }
}
