package taxes;

public abstract class PercentTax extends Tax{
    protected int percent;
    public PercentTax(int percent){
        this.percent=percent;
    }
    public double getMoneyToPay(int value){
        return value*percent/100.0;
    }
}
