import java.util.Calendar;

public class FryPowder extends Material implements Discount {
    public FryPowder(String id,String name, int quantity, int cost,int date, int month, int year){
        this.setId(id);
        this.setName(name);
        this.setQuantity(quantity);
        this.setCost(cost);
        this.setManufactorDate(year,month,date);

    }

    @Override
    public double payment() {
        return this.getQuantity()*this.getCost();
    }

    @Override
    public Calendar expiredDate() {
        Calendar expDate = this.getManufactorDate();
        expDate.add(Calendar.YEAR,1);
        return expDate;
    }

    @Override
    public double totalDiscount(int percent) {
        return this.payment()*percent/100;
    }
}
