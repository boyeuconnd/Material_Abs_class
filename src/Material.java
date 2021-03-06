import java.util.Calendar;

public abstract class Material {
    private String id,name;
    private Calendar manufactorDate = Calendar.getInstance();
    private int quantity,cost;
    public Calendar getManufactorDate() {
        return manufactorDate;
    }

    public Calendar setManufactorDate(int year, int month, int date) {
//        if (month == 12){
//            month =0;
//        }
        this.manufactorDate.set(year,(month-1),date);
        return manufactorDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public Material() {
    }

    public abstract double payment();
    public abstract Calendar expiredDate();
}
