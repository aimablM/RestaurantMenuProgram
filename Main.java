// Restaurant Check Program
// --------------------------------------------------------
// This program allows customers to order food items from
// a restaurant's menu and display the final check.
// --------------------------------------------------------
// Menu Items
// Menu items contains an item name, number of calories,
// price, and whether heart healthy or not.
// --------------------------------------------------------
// The check should be displayed as follows:
// (We are only including main dishes, not drinks, desserts)
//
// ORDERS
// Meat Loaf (450 cal.)       $14.50
// Baked Salmon (260 cal.)    $19.50 (Heart Healthy)
//
// SUBTOTAL (before tax)      $34.00
// TAX (6%)                    $2.04
// TOTAL                      $36.04
//
// RECOMMENDED TIPS
// 10% tip                    $39.64
// 15% tip                    $41.45
// 20% TIP                    $43.25
// --------------------------------------------------------
// The menu options for the program should be as follows:
//
// 1 - View all menu items
// 2 - View heart-healthy items
// 3 - Place order
// 4 - Display check
// --------------------------------------------------------
//import java.nio.file.WatchEvent;
import java.util.InputMismatchException;
import java.util.Scanner;
 

class Main {
   
  public final static double TEN_PERCENT_TIP = 0.10;
  public final static double FIFTEEN_PERCENT_TIP = 0.15;
  public final static double TWENTY_PERCENT_TIP = 0.20;

  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    Menu restaurant_menu = new Menu();
    Check check1 = new Check();
    
    populateMenu(restaurant_menu);
    
    displayMenu(restaurant_menu, check1);
    
  // (to complete)
  }

  public static void populateMenu(Menu menu) {
    final boolean heart_healthy = true;
    final boolean not_heart_healthy = false;

    try {
    menu.add(new MenuItem("Meat Loaf", 450, 
                          "14.50", not_heart_healthy));
    menu.add(new MenuItem("Baked Salmon", 260,
                          "19.50", heart_healthy));
    menu.add(new MenuItem("Bacon Burger", 350, 
                          "24.50", not_heart_healthy));
    menu.add(new MenuItem("Broiled Fish", 290,
                          "22.50", heart_healthy));
    menu.add(new MenuItem("Rare Stake", 550, 
                          "35.50", not_heart_healthy));
    menu.add(new MenuItem("Chipotle Rice", 160,
                          "19.50", heart_healthy));
    menu.add(new MenuItem("Crab Cake", 400, 
                          "17.50", not_heart_healthy));
    menu.add(new MenuItem("Korean Hotdogs", 320,
                          "20.50", heart_healthy));
    menu.add(new MenuItem("Barbeque Wings", 320,
                          "20.50", heart_healthy));
    menu.add(new MenuItem("Chicken Wings", 320,"20.50", heart_healthy));
    menu.add(new MenuItem("Chicken Wings", 320,"20.50", heart_healthy));                      
    // to complete
    } catch (numOrdersExceededException e) {
      System.out.println("\n********************************************\nMaximum number of menu items has been reached! \n********************************************");
    }
  }

  public static void displayMenu(Menu menu, Check check){
    int choice;
    
    do{
    
      try {
     
    System.out.println("-----------------------------------------------------------");
    System.out.println("The menu options for the program should be as follows:\n");
    System.out.println("1 - View all the menu items \n2 - View heart-healthy items \n3 - Place order \n4 - Display check \n5 - To quit");
    System.out.println("-----------------------------------------------------------");
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter option from menu: ");
    choice = input.nextInt();

    switch(choice){
      case 1:
        printMenuWithoutArray(menu);
        break;
      case 2:
        printMenuWithoutArrayH(menu);
        break;
      case 3:
        placeOrder(input, check, menu);
        viewOrders(check);
        break;
      case 4: 
        if(check.getOrder()[0] != null){
          displayCheck(check);
        }
        else{
          System.out.println("No orders yet!");
        }
        break;
      case 5:
        System.out.println("\n-----------------------------------------------------------\n---------------------------QUIT----------------------------\n-----------------------------------------------------------");
        break;
      default:
        System.out.println("Invalid choice, choose from the options above");

    }
      
    } catch (InputMismatchException e) {
      System.out.println("Invalid choice, choose from the options above");
      choice = 0;
    }
    }while(choice != 5);
  }

  public static void printMenuWithoutArrayH(Menu menu){
    int i = 0;
    System.out.println("-----------------------------------------------------------\nHealthy Menu: \n");
    try {
      while(menu.getMenuItem(i) != null){
        if(menu.getMenuItem(i).isHeartHealthy()){
          if(i<9)
            System.out.printf(" %d.  %-20s (%d cal.)   $%-5s (Heart Healthy) %n", (i+1),menu.getMenuItem(i).getName(), menu.getMenuItem(i).getCalories(), menu.getMenuItem(i).price());
            else
          System.out.printf("%d.  %-20s (%d cal.)   $%-5s (Heart Healthy) %n", (i+1),menu.getMenuItem(i).getName(), menu.getMenuItem(i).getCalories(), menu.getMenuItem(i).price());
        }
        
      i++;
    }
    } catch (numOrdersExceededException e) {
      System.out.println("\n-------------All Healthy Menu items Displayed-------------");
    }
    
    System.out.println("\n-----------------------------------------------------------");
  }

  public static void printMenuWithoutArray(Menu menu){
    int i = 0;
    System.out.println("-----------------------------------------------------------\nMenu: \n");
    try {
      while(menu.getMenuItem(i) != null){
        if(menu.getMenuItem(i).isHeartHealthy()){
          if(i<9){
            System.out.printf(" %d.  %-20s (%d cal.)   $%-5s (Heart Healthy) %n", (i+1),menu.getMenuItem(i).getName(), menu.getMenuItem(i).getCalories(), menu.getMenuItem(i).price());
          }
            
          else{
            System.out.printf("%d.  %-20s (%d cal.)   $%-5s (Heart Healthy) %n", (i+1),menu.getMenuItem(i).getName(), menu.getMenuItem(i).getCalories(), menu.getMenuItem(i).price());
          }
        }
    
        else{
          if(i<9){
            System.out.printf(" %d.  %-20s (%d cal.)   $%-5s %n", (i+1),menu.getMenuItem(i).getName(), menu.getMenuItem(i).getCalories(), menu.getMenuItem(i).price());
          }
            else{
              System.out.printf("%d.  %-20s (%d cal.)   $%-5s %n", (i+1),menu.getMenuItem(i).getName(), menu.getMenuItem(i).getCalories(), menu.getMenuItem(i).price());
            }        
        } 
          
      i++;
    }
    } catch (numOrdersExceededException e) {
      System.out.println("\n---------------All Menu items Dispayed---------------");
    }
    
    System.out.println("\n-----------------------------------------------------------");
  }

  public static void viewOrders(Check orders){
    int i = 0;
    try {
      System.out.println("\nORDERS: \n");
      while (i < 4) {
      if(orders.getOrder()[i]!= null){
        MenuItem holder = orders.nextOrder();
        if(holder.isHeartHealthy())
        System.out.printf("%-20s(%d cal.)     $%-5s (Heart Healthy) %n", holder.getName(), holder.getCalories(), holder.price());
        else
        System.out.printf("%-20s(%d cal.)     $%-5s %n", holder.getName(), holder.getCalories(), holder.price());
      }
      
    }
    } catch (NoMoreOrdersException e) {
      System.out.println("\n----------------- All orders currently ----------------\n");
    }
    orders.reset();
  }

  public static void placeOrder(Scanner input, Check orders, Menu menu){
    
    System.out.println("Enter the order you would like place: ");
    int choice = input.nextInt();
    try {
      switch(choice){
      case 1:
      orders.add(menu.getMenuItem(0));
        break;
      case 2:
      orders.add(menu.getMenuItem(1));
        break;
      case 3:
      orders.add(menu.getMenuItem(2));
        break;
      case 4:
      orders.add(menu.getMenuItem(3));
        break;
      case 5:
      orders.add(menu.getMenuItem(4));
        break;
      case 6:
      orders.add(menu.getMenuItem(5));
        break;
      case 7:
      orders.add(menu.getMenuItem(6));
        break;
      case 8:
      orders.add(menu.getMenuItem(7));
        break;
      case 9:
      orders.add(menu.getMenuItem(8));
        break;
      case 10:
      orders.add(menu.getMenuItem(9));
        break;
      default:
        System.out.println("Invalid choice. Choose from the menu!");
        break;
    }
    } 
    catch (InputMismatchException e) {
      System.out.println("Invalid input. Enter a choice from the menu above");
    }
    catch (numOrdersExceededException e) {
      System.out.println("\n***************************************************************\nYou have reached your limit of orders. Please proceed view check. \n*************************************************************** ");
    }
    
  }

  public static void displayCheck(Check check){
   
    double totalPreTax = check.total();
    double tax = check.total() * check.getTax();
    double totalAfterTax = totalPreTax + tax;

    viewOrders(check);

    System.out.println("");
    System.out.printf("%-34s $%.2f %n", "SUBTOTAL: (Before tax)",totalPreTax);
    System.out.printf("%-34s $%.2f %n", "TAX",tax);
    System.out.printf("%-34s $%.2f %n", "TOTAL",totalAfterTax);
    
    System.out.println("");
    System.out.printf("%-34s $%.2f %n","10% TIP ",((totalAfterTax * TEN_PERCENT_TIP) + totalAfterTax));
    System.out.printf("%-34s $%.2f %n","15% TIP " ,((totalAfterTax * FIFTEEN_PERCENT_TIP) + totalAfterTax));
    System.out.printf("%-34s $%.2f %n","20% TIP " ,((totalAfterTax * TWENTY_PERCENT_TIP) + totalAfterTax));

  }
  
}