import java.util.ArrayList;
import java.util.Scanner;


class CustomPizza {
    private String toppings;
    private double price;

    public CustomPizza(String toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomPizza [toppings=" + toppings + ", price=" + price + "]";
    }
}

public class HandleOrders {

    private static final double PIZZA_BASE_PRICE = 10.0;

    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;
    private int numberOfPizzasOrdered = 0;
    StringBuilder pizzaOrderSummary = new StringBuilder();
    Scanner input = new Scanner(System.in);

    private ArrayList<CustomPizza> customPizzas = new ArrayList<>();

    public void takeOrder(){
        String orderAnother = "Y";
        int j= 0;
        int m = 0;
        int n = 0;
        int p = 0;

        do{
            int i = 1;
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve: \n");
            for(PizzaSelection pizza : PizzaSelection.values()){
                System.out.println(i + ". " + pizza);
                i++;
            }
            System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose: \n");

            System.out.println("Please enter your choice (1-6): \n");
            int choice = input.nextInt();
            input.nextLine();
            

            if(choice>0 && choice<6){
                switch(choice){
                    case 1:
                        System.out.println("You have selected " + PizzaSelection.PEPPERONI);
                        pizzasOrdered[j] = PizzaSelection.PEPPERONI.toString();
                        totalOrderPrice += PizzaSelection.PEPPERONI.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 2:
                        System.out.println("You have selected " + PizzaSelection.HAWAIIAN);
                        pizzasOrdered[j] = PizzaSelection.HAWAIIAN.toString();
                        totalOrderPrice += PizzaSelection.HAWAIIAN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 3:
                        System.out.println("You have selected " + PizzaSelection.VEGGIE);
                        pizzasOrdered[j] = PizzaSelection.VEGGIE.toString();
                        totalOrderPrice += PizzaSelection.VEGGIE.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 4:
                        System.out.println("You have selected " + PizzaSelection.BBQ_CHICKEN);
                        pizzasOrdered[j] = PizzaSelection.BBQ_CHICKEN.toString();
                        totalOrderPrice += PizzaSelection.BBQ_CHICKEN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 5:
                        System.out.println("You have selected " + PizzaSelection.EXTRAVAGANZA);
                        pizzasOrdered[j] = PizzaSelection.EXTRAVAGANZA.toString();
                        totalOrderPrice += PizzaSelection.EXTRAVAGANZA.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    default:
                        System.out.println("Incorrect choice. Please try again.");
                        break;
                }
            } else if (choice == 6){
                StringBuilder toppingsBuilder = new StringBuilder();
                
                System.out.println("For your custom pizza, here are the toppings:");
                int k = 1;
                for(PizzaToppings topping : PizzaToppings.values()){
                    System.out.println(k + ". " + topping);
                    k++;
                }
                System.out.println("Please enter a maximum of 10 topping choices.\n");

                

                int l = 1;
                do{
                    System.out.println("Enter topping #" + l + ". To stop, type 0: ");
                    int toppingChoice = input.nextInt();
                    input.nextLine();
                    if(toppingChoice == 0){
                        break;
                    }
                    toppingsBuilder.append(PizzaToppings.values()[toppingChoice - 1].getTopping() + ", ");
                } while (l < 10);
          
                double customPizzaPrice = PIZZA_BASE_PRICE;
                for (int toppingIndex = 0; toppingIndex < toppingsBuilder.length(); toppingIndex++) {
                    customPizzaPrice += PizzaToppings.values()[toppingIndex].getToppingPrice();
                }
                CustomPizza customPizza = new CustomPizza(toppingsBuilder.toString(), customPizzaPrice);
                customPizzas.add(customPizza);


                   
                
                customPizzaPrice += PIZZA_BASE_PRICE;
                StringBuilder customPizzaStr = new StringBuilder(" Custom Pizza with ");
                customPizzaStr.append(toppingsBuilder).append(": €").append(customPizzaPrice);
            

                pizzasOrdered[j] = customPizza.toString();
                totalOrderPrice += customPizzaPrice;
                numberOfPizzasOrdered++;
                j++;


            }

            i = 1;
            System.out.println("Here are the pizza sizes options: \n");
            for(PizzaSize pizza : PizzaSize.values()){
                System.out.println(i + ". " + pizza);
                i++;
            }

            System.out.println("Pick one size (1 - 3): \n");
            int sizeChoice = input.nextInt();
            input.nextLine();

            pizzaSizesOrdered[m] = PizzaSize.values()[sizeChoice-1].getPizzaSize() + ": €" + PizzaSize.values()[sizeChoice-1].getAddToPizzaPrice();
            totalOrderPrice += PizzaSize.values()[sizeChoice-1].getAddToPizzaPrice();
            m++;

            System.out.println("Here are the side dishes options: \n");
            i = 1;
            for(SideDish sideDish : SideDish.values()){
                System.out.println(i + ". " + sideDish);
                i++;
            }

            System.out.println("Pick one side dish (1 - 4): \n");
            int sideDishChoice = input.nextInt();
            input.nextLine();

            sideDishesOrdered[n] = SideDish.values()[sideDishChoice-1].getSideDishName() + ": €" + SideDish.values()[sideDishChoice-1].getAddToPizzaPrice();
            totalOrderPrice += SideDish.values()[sideDishChoice-1].getAddToPizzaPrice();
            n++;

            System.out.println("Here are the drinks options: \n");
            i = 1;
            for(Drinks drink : Drinks.values()){
                System.out.println(i + ". " + drink);
                i++;
            }

            System.out.println("Pick one drink (1 - 3): \n");
            int drinkChoice = input.nextInt();
            input.nextLine();

            drinksOrdered[p] = Drinks.values()[drinkChoice-1].getDrinkName() + ": €" + Drinks.values()[drinkChoice-1].getAddToPizzaPrice();
            totalOrderPrice += Drinks.values()[drinkChoice-1].getAddToPizzaPrice();
            p++;

            System.out.println("Would you like to order another pizza? (Y/N): \n");
            orderAnother = input.nextLine();
            

        }while(orderAnother.equalsIgnoreCase("Y"));


    }

    public void createOrderSummary(){
        
        pizzaOrderSummary.append("\nThank you for dining with Slice-o-Heaven. Your order details are as follows: \n");

        for(int i=0; i<numberOfPizzasOrdered; i++){
            pizzaOrderSummary.append((i+1) + pizzasOrdered[i] + "\n");
            pizzaOrderSummary.append(pizzaSizesOrdered[i] + "\n");
            pizzaOrderSummary.append(sideDishesOrdered[i] + "\n");
            pizzaOrderSummary.append(drinksOrdered[i] + "\n \n");
            
        }

        pizzaOrderSummary.append("ORDER TOTAL: €" + totalOrderPrice + "\n");

    }

    @Override
    public String toString(){
        
        return pizzaOrderSummary.toString();
    }
    public void displayCustomPizzas() {
        for (CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }

    public static void main(String[] args) throws Exception {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.takeOrder();
        handleOrders.displayCustomPizzas();
        handleOrders.createOrderSummary();
        System.out.println(handleOrders);
    }
}


enum PizzaSelection {
    PEPPERONI(12.0),
    HAWAIIAN(13.0),
    VEGGIE(11.0),
    BBQ_CHICKEN(14.0),
    EXTRAVAGANZA(15.0);

    private double price;

    PizzaSelection(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

enum PizzaToppings {
    CHEESE(2.0),
    PEPPERONI(3.0),
    MUSHROOM(2.5),
    ONION(2.0);

    private double toppingPrice;

    PizzaToppings(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public String getTopping() {
        return name();
    }
}

enum PizzaSize {
    SMALL("Small", 1.0),
    MEDIUM("Medium", 2.0),
    LARGE("Large", 3.0);

    private String pizzaSize;
    private double addToPizzaPrice;

    PizzaSize(String pizzaSize, double addToPizzaPrice) {
        this.pizzaSize = pizzaSize;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }
}

enum SideDish {
    FRIES("French Fries", 4.0),
    WINGS("Chicken Wings", 6.0),
    GARLIC_BREAD("Garlic Bread", 3.0),
    ONION_RINGS("Onion Rings", 5.0);

    private String sideDishName;
    private double addToPizzaPrice;

    SideDish(String sideDishName, double addToPizzaPrice) {
        this.sideDishName = sideDishName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getSideDishName() {
        return sideDishName;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }
}

enum Drinks {
    COKE("Coke", 2.0),
    SPRITE("Sprite", 2.0),
    ORANGE_JUICE("Orange Juice", 3.0);

    private String drinkName;
    private double addToPizzaPrice;

    Drinks(String drinkName, double addToPizzaPrice) {
        this.drinkName = drinkName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }


    
}
