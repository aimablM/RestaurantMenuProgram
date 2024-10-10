public class MenuItem {
  private String item_name;
  private int num_calories;
  private String price;
  private boolean heart_healthy;

  // constructor 
  public MenuItem (String item_name, int num_calories,
                   String price, boolean heart_healthy) {
  this.item_name = item_name;
  this.num_calories = num_calories;
  this.price = price;
  this.heart_healthy = heart_healthy;
   
  }

  public String getName(){
    return item_name;
  }

  public int getCalories(){
    return num_calories;
  }

  public String price(){
    return price;
  }
  
  // getters (for item_name, num_calories, price)
  // (to complete)


  // boolean method
  public boolean isHeartHealthy() {
    // (to complete)
    if(heart_healthy){
      return true;
    }
    else
    return false;
  }

  // toString method
  public String toString() {
  // ------------------------------------------------------
  // Returns string of the form:
  //
  // "Meat Loaf (450 cal.) $14.50"
  // "Baked Salmon (260 cal.) $19.50 (Heart Healthy)"
  // ------------------------------------------------------
  // (to complete)
  if(isHeartHealthy()){
    return item_name + " (" + num_calories + " cal.) $" + price + "(Heart Healthy)";
  }
  return item_name + " (" + num_calories + " cal.) $" + price;

}
}