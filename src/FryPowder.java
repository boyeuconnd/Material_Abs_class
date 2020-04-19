import java.util.Calendar;

public class FryPowder extends Material implements Discount {
    public FryPowder(String id,String name, int quantity, int cost){
        this.setId(id);
        this.setName(name);
        this.setQuantity(quantity);
        this.setCost(cost);

    }

    @Override
    public double payment() {
        return this.getQuantity()*this.getCost();
    }

    @Override
    public Calendar expiredDate() {
        Calendar expDate = super.getManufactorDate();
        expDate.add(Calendar.YEAR,1);
        return null;
    }

    @Override
    public double totalDiscount(int percent) {
        return this.payment()*percent/100;
    }
}
