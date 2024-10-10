public class Menu {
  private MenuItem[] menu_items;
  public final double tax_rate = 0.06;
  private int i = 0;
  private int current_index = 0; // should only be used by
                                 // iterator methods
  // Constructor
  public Menu() {
  // ------------------------------------------------------
  // Initalizes menu_items array to size 10 with all nulls.
  // ------------------------------------------------------
    menu_items = new MenuItem[10];
    
    for(int i = 0; i < menu_items.length; i++)
      menu_items[i] = null;
  }

  public MenuItem getMenuItem(int i){
      if(i < 10){
        return menu_items[i];
      }

    else{
      throw new numOrdersExceededException();
    }
  }
  
  public MenuItem[] getMenu(){
        return menu_items;
  }

  public void add(MenuItem item) throws numOrdersExceededException{
  // ------------------------------------------------------
  // Adds menu item to next available space in array 
  // menu_items.
  // Throws numOrdersExceededException if menu_items array
  // is full.
  // ------------------------------------------------------
  // (to complete)

  if(i < 10 && menu_items[i] == null){
    menu_items[i] = item;
  i++;
  }
  else{
    throw new numOrdersExceededException();
  }
}

  // Iterator Method
  // These methods are used to iterate over the menu items.
  // Items may be iterated over multiple times by calling
  // reset to begin at the first order item again.
  public void reset() {
  // ------------------------------------------------------
  // Resets to first order of list of menu items.
  // ------------------------------------------------------
    current_index = 0;
  }

  public MenuItem firsItem(){
    return menu_items[0];
  }

  public boolean hasNext() {
  // ------------------------------------------------------
  // Returns true if there exists another menu item to
  // retrieve from list of menu items. Otherwise, returns
  // false.
  // ------------------------------------------------------
  // (to complete)
 
  if(menu_items[current_index] == null){
      System.out.println("They doesn't exist a next order");
      return false;
    }
  return true;
}

  public MenuItem nextOrder() {
  // ------------------------------------------------------
  // PRECOND: hasNext() = true
  // Returns next menu item in array of menu items.
  // ------------------------------------------------------
  // (to complete)
    if(hasNext()){
      return menu_items[current_index + 1];
    }
    return menu_items[current_index];
  }
  
}