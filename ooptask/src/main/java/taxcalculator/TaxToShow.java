package taxcalculator;

public class TaxToShow {
    private double money;
    private String name;

    public TaxToShow(String name,double money) {
        this.money = money;
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tax " + name + ": " + money+"\n";
    }
}
