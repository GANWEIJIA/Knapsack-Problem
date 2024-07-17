
import java.util.*;

public class GreedyApproach extends Solution  {
	
	private ArrayList <Item> selectedItem;
	
	public GreedyApproach(ArrayList <Item> items, int capacity, ArrayList<Item> selectedItem)
	{
		super(items, capacity);
		this.selectedItem = selectedItem;
	}
	
	public void solve()
	{
		ArrayList <Item> items = this.getItem();
		int capacity = this.getCapacity();
		
		Collections.sort(items, Comparator.comparingDouble(item -> (double) item.getValue() / item.getWeight()));
        double totalValue = 0;
        int currentCapacity = capacity;
        
        for (int i = items.size() - 1; i >= 0; i--) {
            if (currentCapacity >= items.get(i).getWeight()) {
                totalValue += items.get(i).getValue();
                currentCapacity -= items.get(i).getWeight();
                selectedItem.add(items.get(i));
            } 
        }
        double maxValue = totalValue;
        
        System.out.println("\nCAPACITY\t\t" + capacity);
        System.out.println("MAXIMUM VALUE THAT CAN BE OBTAINED: " + maxValue);
        
        System.out.println("\nSELECTED ITEMSs:");
        for (Item item : selectedItem) {
            System.out.println(item.getName());
        }
        System.out.println();
	}
}
