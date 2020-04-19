import java.util.Calendar;

public class Meat extends Material implements Discount {
    private int unit;
    private double weight;
    private int discountRate;

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public Meat(String id,String name, int quantity, int cost,int unit,double weight){
        this.setId(id);
        this.setName(name);
        this.setQuantity(quantity);
        this.setCost(cost);
        this.setUnit(unit);
        this.setWeight(weight);
    }



    @Override
    public double payment() {
        double price = this.getQuantity()*this.getCost()*this.getUnit()*this.getWeight();
        return price;
    }

    @Override
    public Calendar expiredDate() {
        Calendar expDate = super.getManufactorDate();
        expDate.add(Calendar.DAY_OF_MONTH,15);
        return null;
    }

    @Override
    public double totalDiscount(int percent) {
        return this.payment()*percent/100;
    }
}
