package income;

public class Income {
    private int mainIncome,additionalIncome,authorIncome,amountOfCars,giftIncome,realEstateIncome,transferIncome;
    public Income(int mainIncome, int additionalIncome, int authorIncome, int amountOfCars, int giftIncome, int realEstateIncome, int transferIncome) {
        this.mainIncome = mainIncome;
        this.additionalIncome = additionalIncome;
        this.authorIncome = authorIncome;
        this.amountOfCars = amountOfCars;
        this.giftIncome = giftIncome;
        this.realEstateIncome = realEstateIncome;
        this.transferIncome = transferIncome;
    }
    public Income(){
        IncomeReader reader = new IncomeReader();
        Income toCopy = reader.read();
        this.mainIncome=toCopy.mainIncome;
        this.additionalIncome = toCopy.additionalIncome;
        this.authorIncome=toCopy.authorIncome;
        this.amountOfCars=toCopy.amountOfCars;
        this.giftIncome=toCopy.giftIncome;
        this.realEstateIncome=toCopy.realEstateIncome;
        this.transferIncome=toCopy.transferIncome;
    }
}
