import java.util.Calendar;

public class Meat extends Material implements Discount {
    private int unit;
    private double weight;

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
    public Meat(String id,String name, int cost,int unit,double weight,int date,int month,int year){
        this.setId(id);
        this.setName(name);
        this.setCost(cost);
        this.setUnit(unit);
        this.setWeight(weight);
        this.setManufactorDate(year,month,date);
    }



    @Override
    public double payment() {
        double price = this.getCost()*this.getUnit()*this.getWeight();
        return price;
    }

    @Override
    public Calendar expiredDate() {
        Calendar expDate = this.getManufactorDate();
        expDate.add(Calendar.DAY_OF_MONTH,15);

        return expDate ;
    }

    @Override
    public double totalDiscount(int percent) {
        return this.payment()*percent/100;
    }
}
