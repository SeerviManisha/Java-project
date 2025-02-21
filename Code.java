import java.util.Scanner;
// import java.util.ArrayList;

class Restaurant {
    public String RestaurantName;
    public String Location;

    Restaurant(String name, String loc) {
        this.RestaurantName = name;
        this.Location = loc;
    }

    void print() {
        System.out.println("Restaurant that is being preferred is: " + RestaurantName);
        System.out.println("Location is: " + Location);
        System.out.println("Here is the menu.........");
    }
}

class Menu {
    int dishes = 16;
    int drinks = 10;

    public void run1(int dishes) {
        this.dishes = dishes;
    }

    public void run2(int drinks) {
        this.drinks = drinks;
    }
}

class Dishes extends Menu {
    String dishes[] = { "Veg Manchurian", "Idly", "Jeera Rice", "Chole Bhature", "Ice creams",
            "Spring roll", "Dosa", "Veg dum biryani", "Butter Paneer", "Gulab Jamun",
            "Veg Noodles","Naan","Butter Naan"};
    int dishesprice[] = { 180, 100, 150, 400, 100, 200, 100, 350, 300, 120, 160 ,120,150};

    public void run() {
        System.out.println("\nDISHES\n");
        for (int i = 0; i < dishes.length; i++) {
            System.out.println(i + 1 + "." + dishes[i] + " - " + dishesprice[i] + "/-");
        }
    }

    public int getDishPrice(int index) {
        return dishesprice[index];
    }
}

class Drinks extends Menu {
    String drinks[] = { "Mojito", "Sprite", "Banana shake", "Coca Cola", "Oreo shake",
            "Chocolate drink" };
    int drinksprice[] = { 200, 50, 150, 50, 150, 200 };

    public void run1() {
        System.out.println("\nDRINKS\n");
        for (int i = 0; i < drinks.length; i++) {
            System.out.println(i + 1 + "." + drinks[i] + " - " + drinksprice[i] + "/-");
        }
    }

    public int getDrinkPrice(int index) {
        return drinksprice[index];
    }
}
class Details {
    private String TableNo;
    private double Amount;
    public void setTableNo(String tno) {
        this.TableNo = tno;
    }
    public String getTableNo() {
        return TableNo;
    }
    public void setAmount(int amt) {
        this.Amount = amt;
    }
    public double getAmount() {
        return Amount;
    }
}
public class Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the location");
        String Location = sc.nextLine();
        System.out.println("Here are the available nearby restaurants:");
        String[] restaurants = { "Santosh Dhaba", "Rotis", "Sawarna", "Ahoy Resto", "Tatva", "Khaki" };
        int i = 1;
        for (String x : restaurants) {
            System.out.println(i + "." + x);
            i++;
        }
        System.out.println("\n");
        System.err.println("Select the restaurant by choosing the number");
        int restaurantselected = sc.nextInt();
        Restaurant h = new Restaurant(restaurants[restaurantselected - 1], Location);
        h.print();

        Dishes d = new Dishes();
        d.run();
        Drinks d1 = new Drinks();
        d1.run1();

        // Multiple orders
        int totalCost = 0;
        boolean ordering = true;

        while (ordering) {
            System.err.println("Order the dishes based on index values");
            int dishIndex = sc.nextInt() - 1;
            totalCost += d.getDishPrice(dishIndex);
            System.err.println("Order the drinks based on index values");
            int drinkIndex = sc.nextInt() - 1;
            totalCost += d1.getDrinkPrice(drinkIndex);
            System.out.println("Do you want to order more? (yes/no)");
            sc.nextLine();
           String moreOrders = sc.nextLine();
            if (!moreOrders.equalsIgnoreCase("yes")) {
                ordering = false;
            }
        }
        System.out.println("Total amount to be paid: " + totalCost + "/-");
        System.out.println("Thank you visit again!!");    
        sc.close();
    }
}
