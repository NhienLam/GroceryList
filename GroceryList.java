package GroceryList;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Builds a Grocery List that keep user on track and streamline shopping 
 * @author Nhien (Ricky) Lam
 */
public class GroceryList
{
	private ArrayList<GroceryItem> list; 
	
	public GroceryList()
	{
		list = new ArrayList<>();
	}
	
	/**
	 * Checks if the variable is the Integer type
	 * @param str the target that needs to check
	 * @return  true if the input is an integer, else return false
	 */
	public boolean isInteger(String str) 
	{ 	   
		try 
		{
			Integer.parseInt(str);  // Make an input to an integer
			return true; 
		}
		catch( Exception e) 
		{ 
			// return false if the input cannot be made to an integer
			return false;
		}
	} 
	
	public void add()
	{
		System.out.println("* ADD *");
		
		Scanner in = new Scanner(System.in);
		
	    // get item from user
		System.out.print("Enter name of item: ");
		String name = in.nextLine();
		System.out.print("Enter number of items: ");
		String num = in.nextLine();
		
		// check if it is an integer
		while(!isInteger(num))
		{
			System.out.print("ERROR: Invalid input for number of items! Please enter again: ");
			num = in.nextLine();
		}
		
		int number = Integer.valueOf(num);
		
	    // check for negative integers
		while(number < 1)
		{
			System.out.print("Invalid input for number of items! Please enter again: ");
			num = in.nextLine();
		}
		
		list.add(new GroceryItem(name, number));
		
		displayOptions();
	}
	
	public void remove()
	{
		System.out.println("* REMOVE *");

		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter name of item to remove: ");
		String name = in.nextLine();
		System.out.print("Enter number of items to remove: ");
		String num = in.nextLine();
		
		// check if it is an integer
		while(!isInteger(num))
		{
			System.out.println("ERROR: Invalid input for number of items!");
			System.out.print("Please enter again: ");
			num = in.nextLine();
		}

		int number = Integer.valueOf(num);

		// check for negative integers
		while(number < 1)
		{
			System.out.println("ERROR: Number of items cannot be negative!");
			System.out.print("Please enter again: ");
			num = in.nextLine();
		}
		
		GroceryItem item = new GroceryItem(name, number);
		
		// check if the item is in the List
		if(!list.contains(item))
		{
			System.out.println("Sorry! There is no such Item in your Grocery List.");
		}
		else
		{
			list.remove(item);
			System.out.println("Item is removed");
		}
		
		displayOptions();
	}
	
	public int totalItems()
	{
		return list.size();
	}
	
	public int totalQuantity()
	{
		int total = 0;
		
		for(GroceryItem gi : list)
		{
			total += gi.getQuantity();
		}
		
		return total;
	}
	
	public void display()
	{
		System.out.println("*** Grocery List *** \n");
		
		for(GroceryItem gi : list)
		{
			System.out.println(gi.toString());
		}
		System.out.println("-----------");
		System.out.println("Total items:  " + totalItems());
		System.out.println("Total quanity: " + totalQuantity() + "\n");
		
		System.out.println("*** End of List *** \n");
	}
	 
	public String displayOptions()
	{
		// valid input options
		String s = "ardq";

		// diplay options
		System.out.println("*** *** *** ***");
		System.out.println("Enter 'A' to Add");
		System.out.println("Enter 'R' to Remove");
		System.out.println("Enter 'D' to Display");
		System.out.println("Enter 'Q' to Quit");
		System.out.print("Enter your choice: ");
		
		// get input from user
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		while(choice.length() != 1)
		{
			System.out.println("ERROR: Please enter a character: ");
			choice = in.next();
		}
		
		while(!s.contains(choice))
		{
			System.out.println("ERROR: Please enter one of the options: ");
			choice = in.next();
		}
		
		return choice;
	}
	
	public static void main(String[] args)
	{
		GroceryList glist = new GroceryList();
	
		String choice = " ";
		while (!choice.equals("q"))
		{
			choice = glist.displayOptions();
			
			// Add grocery item
			if(choice.equals("a"))
			{
				glist.add();
			}
			
			// Remove grocery item
			else if(choice.equals("r"))
			{
				glist.remove();
			}
			
			// Display the current list
			else if(choice.equals("d"))
			{
				glist.display();
			}
		}
		
		System.out.println("Thank you!");
	}
}
