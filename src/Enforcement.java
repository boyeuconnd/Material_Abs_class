import java.util.Calendar;

public class Enforcement {
    public static void main(String[] args) {
        Material[] MaterialList = new Material[10];
        MaterialList[0] = new FryPowder("FP01", "PowderA", 10, 20000);
        MaterialList[1] = new FryPowder("FP02", "PowderB", 120, 30000);
        MaterialList[2] = new FryPowder("FP03", "PowderC", 50, 15000);
        MaterialList[3] = new FryPowder("FP04", "PowderD", 90, 18000);
        MaterialList[4] = new FryPowder("FP05", "PowderE", 25, 27000);
        MaterialList[5] = new Meat("M01", "Folk", 30, 80000, 5, 5);
        MaterialList[6] = new Meat("M02", "SheepMeat", 16, 140000, 10, 5.5);
        MaterialList[7] = new Meat("M03", "FishMeat", 20, 300000, 6, 10.5);
        MaterialList[8] = new Meat("M04", "CowMeat", 40, 250000, 12, 3.3);
        MaterialList[9] = new Meat("M05", "ChickenMeat", 30, 57000, 3, 7.2);
        double totalMoney = 0;
        double totalPowderMoney = 0;
        double totalMeatMoney = 0;
        double totalDiscountMoney = 0;
        for (Material elements : MaterialList
        ) {
            if (elements instanceof FryPowder) {
                FryPowder fryPowderElements = (FryPowder) elements;
                totalMoney += fryPowderElements.payment();
                totalPowderMoney += fryPowderElements.payment();
                totalDiscountMoney += (fryPowderElements.totalDiscount(10));
            } else if (elements instanceof Meat) {
                Meat meatElements = (Meat) elements;
                totalMoney += meatElements.payment();
                totalMeatMoney += meatElements.payment();
                totalDiscountMoney += (meatElements.totalDiscount(5));
            }
        }
        System.out.printf("Total money to buy all products List: %15.2f vnd \n", totalMoney);
        System.out.printf("Include FryPowder: %10.2f vnd \n", totalPowderMoney);
        System.out.printf("Include Meat: %10.2f vnd\n", totalMeatMoney);
        System.out.printf("Total money got Discount: %10.2f vnd\n", totalDiscountMoney);
    }
}
