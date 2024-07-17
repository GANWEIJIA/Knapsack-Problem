import java.util.ArrayList;
import java.util.Scanner;

public class TestKnapsack {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		String mainMenu = ("WELCOME TO STORAGE RESTOCK FOR PHONE ACCESSORIES SYSTEM...\n"
				+ "CAPACITY OF THE STORAGE IS 6000\n"
				+ "1. Add item\n"
				+ "2. Dynamic solution\n"
				+ "3. Greedy solution\n"
				+ "4. Exit\n"
				+ "\nOption: ");
		
		ArrayList <Item> items = new ArrayList <Item>();
        
		int choice = 0;
		int capacity = 6000;
        int size = items.size();
		      
		boolean cdone = false;
		do {
			
			size = items.size();
			System.out.print(mainMenu);
			try
			{
			choice = Integer.parseInt(sc.nextLine());
			
			while(choice < 1 || choice >4) {
				System.out.print("\nError! Incorrect choice.\n");
		        System.out.print(mainMenu);
		        choice = Integer.parseInt(sc.nextLine());
		       
			}
			 cdone= true;
			}
			
			catch(NumberFormatException exception)
		     {
		    	 System.out.print("\nOnly Numbers ! Please try again");
		     }
			 System.out.println();
			 
			switch(choice) {
			
			case 1:{
				boolean con = true;
					do {
					con = false;
					System.out.print("PLEASE ENTER THE ITEM THAT YOU WOULD LIKE TO ADD FOR RESTOCK...\n");
					System.out.print("Item name: ");
					String itemName = sc.nextLine();
					try {
					System.out.print("Enter the weights of " + itemName +" : ");
					int weight = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the values of " + itemName +" : ");
					int value = Integer.parseInt(sc.nextLine());
		            items.add(new Item(itemName,weight, value));
		            System.out.println("SUCCESSFULLY ADDED...");
		            System.out.print("DO YOU WISH TO CONTINUE ADD ITEM?('Y' OR 'y' TO CONTINUE): ");
		            String cadd = sc.nextLine();
		            if(cadd.equals("Y") || cadd.equals("y"))
		            	con = true;
		            else 
		            	System.out.println("Returning to main menu...");
					}
					
					   catch(NumberFormatException exception)
					{
							System.out.print("\nOnly Number! Please try again\n");
					}
					System.out.println();
					}while(con == true);
				break;
	    }
		case 2:{
	        Solution s= new DynamicApproach(items, capacity);
	        s.disCurrentItem();
	        s.solve();
	        break;
				}
		
		case 3:{
			ArrayList<Item> selectedItems = new ArrayList<>();
			
			
			  Solution s= new GreedyApproach(items, capacity,selectedItems);
				s.disCurrentItem();
		        s.solve();
	        break;
	        }
	        
			}
		
		}while(choice != 4);
		System.out.println("THANK YOU FOR USING THE SYSTEM...");
	}
}
