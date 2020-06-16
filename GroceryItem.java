package GroceryList;

/**
 * Models a Grocery Item
 */
public class GroceryItem 
{
    private int quantity;
    private String description;

    /**
     * Constructs a Grocery Item with a price and a description
     * @param thePrice the price of this Item
     * @param theDescription - the description of this Item
     */
    public GroceryItem(String theDescription, int theQuantity)
    {
    	quantity = theQuantity;
        description = theDescription;
        
    }

    /**
     * Gets the quantity
     * @return the quantity of this GroceryItem object
     */
    public int getQuantity()
    {
         return quantity;
    }
    
    /**
     * Gets the description
     * @return the description of the GroceryItem object
     */
    public String getDescription()
    {
        return description;
    }
    
    @Override
    /**
     * Returns the String representation of the GroceryItem
     */
    public String toString()
    {
       return description 
             + ":   " + quantity;
    }
    
    @Override
    /**
     * Checks if 2 GroceryItems are the same
     */
    public boolean equals(Object otherObject)
    {
       if (otherObject == null) 
       {
    	   return false;
       }
       if (this.getClass() != otherObject.getClass()) 
       {
    	   return false;
       }
       
       GroceryItem other = (GroceryItem)otherObject;
       return quantity == other.quantity
             && description.equals(other.description);
    }
}