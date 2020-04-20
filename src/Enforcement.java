import java.util.Calendar;

public class Enforcement {
    public static void main(String[] args) {
        Material[] MaterialList = new Material[10];
        MaterialList[0] = new FryPowder("FP01", "PowderA", 10, 20000,24,8,2019);
        MaterialList[1] = new FryPowder("FP02", "PowderB", 120, 30000,15,9,2019);
        MaterialList[2] = new FryPowder("FP03", "PowderC", 50, 15000,16,12,2019);
        MaterialList[3] = new FryPowder("FP04", "PowderD", 90, 18000,1,6,2019);
        MaterialList[4] = new FryPowder("FP05", "PowderE", 25, 27000,12,7,2019);
        MaterialList[5] = new Meat("M01", "Folk", 30, 80000,  5,7,4,2020);
        MaterialList[6] = new Meat("M02", "SheepMeat", 16, 140000,  5.5,10,4,2020);
        MaterialList[7] = new Meat("M03", "FishMeat", 20, 300000,  10.5,17,4,2020);
        MaterialList[8] = new Meat("M04", "CowMeat", 40, 250000,  3.3,13,4,2020);
        MaterialList[9] = new Meat("M05", "ChickenMeat", 30, 57000,  7.2,14,4,2020);
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
                System.out.println(daysRemaining(elements));
                int flagcheck = daysRemaining(elements)+1;
                if(flagcheck>120){
                    totalDiscountMoney += (fryPowderElements.totalDiscount(5));
                }else if(flagcheck>60){
                    totalDiscountMoney += (fryPowderElements.totalDiscount(20));
                }else if(flagcheck>0){
                    totalDiscountMoney += (fryPowderElements.totalDiscount(40));
                }else {
                    totalDiscountMoney += (fryPowderElements.totalDiscount(100));
                }
            } else if (elements instanceof Meat) {
                Meat meatElements = (Meat) elements;
                totalMoney += meatElements.payment();
                totalMeatMoney += meatElements.payment();
                System.out.println(daysRemaining(elements));
                int flag = daysRemaining(elements)-15;
                if(flag>05){
                    totalDiscountMoney += (meatElements.totalDiscount(5));
                }else if(flag>03){
                    totalDiscountMoney += (meatElements.totalDiscount(20));
                }else if(flag>0){
                    totalDiscountMoney += (meatElements.totalDiscount(40));
                }else {
                    totalDiscountMoney += (meatElements.totalDiscount(100));
                }


            }
        }
        System.out.printf("Total money to buy all products List: %15.2f vnd \n", totalMoney);
        System.out.printf("Include FryPowder: %10.2f vnd \n", totalPowderMoney);
        System.out.printf("Include Meat: %10.2f vnd\n", totalMeatMoney);
        System.out.printf("Total money got Discount: %10.2f vnd\n", totalDiscountMoney);
        showDate(MaterialList[2].getManufactorDate());


    }
    public static int daysRemaining(Material material){
        Calendar today = Calendar.getInstance();
        Calendar expDate = material.expiredDate();
        int remainDays = expDate.get(Calendar.DAY_OF_YEAR)-today.get(Calendar.DAY_OF_YEAR);
        return remainDays;
    }

    public static void showDate(Calendar date) {
        System.out.print(date.get(Calendar.DAY_OF_MONTH) + " ");
        System.out.print((date.get(Calendar.MONTH)+1) + " ");
        System.out.println(date.get(Calendar.YEAR));
    }
}
