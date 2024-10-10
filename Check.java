public class Check {
  private MenuItem[] orders;
  private int i = 0;
  private final double tax_rate = 0.06;
  private int current_index = 0; // should only be used by
                                 // iterator methods
  // Constructor
  public Check() {
  // ------------------------------------------------------
  // Initalizes orders array to size 4 with all nulls.
  // ------------------------------------------------------
    orders = new MenuItem[4];
    
    for(int i = 0; i < orders.length; i++)
      orders[i] = null;
  }

  public double getTax(){
    return tax_rate;
  }
  public void add(MenuItem item) 
                    throws numOrdersExceededException {
  // ------------------------------------------------------
  // Adds item to next available space in array orders.
  // Throws numOrdersExceededException if orders array
  // is full.
  // ------------------------------------------------------
  // (to complete) 
    
    if(i > 3){
        throw new numOrdersExceededException();
    }
    else if(orders[i] == null){
      orders[i] = item;
    }
    i++;
  }

  public MenuItem[] getOrder(){
    return orders;
  }

  public double total() {
  // ------------------------------------------------------
  // Returns total cost of orders on check.
  // ------------------------------------------------------
  // (to complete)
  int i = 0; 
  double total = 0;

  while(i < 4){
    if(orders[i] != null){
      double price = Double.parseDouble(orders[i].price());
    total += price;
    }
    i++;
   }
  return total;
  }

  // Iterator Method
  // These methods are used to iterate over the order items.
  // Items may be iterated over multiple times by calling
  // reset to begin at the first order item again.
  public void reset() {
  // ------------------------------------------------------
  // Resets to first order of list of orders.
  // ------------------------------------------------------
    current_index = 0;
  }

  public boolean hasNext() {
  // ------------------------------------------------------
  // Returns true if there exists another order to retrieve
  // from list of orders. Otherwise, returns false.
  // ------------------------------------------------------
  // (to complete)
  
  if(current_index < 4 && (orders[current_index] != null)){
    return true;
  }
    return false;
}

  public MenuItem nextOrder() throws NoMoreOrdersException{
  // ------------------------------------------------------
  // PRECOND: hasNext() = true
  // Returns next order in list of orders.
  // ------------------------------------------------------
  // (to complete)
    
  if(hasNext()){
    int tempHolder = current_index;
      current_index++;
      return orders[tempHolder];
    }
    else{
      throw new NoMoreOrdersException();
    }
    
  }

}