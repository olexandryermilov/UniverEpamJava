package taxes;

public abstract class ValueTax extends Tax {
    protected double valueToPay;
    public ValueTax(double valueToPay){
        this.valueToPay=valueToPay;
    }
    public double getMoneyToPay(int amount){
        return amount*valueToPay;
    }
}
