import java.util.ArrayList;
public abstract class Solution implements DisplayItem {
		private ArrayList <Item> items;
		private int capacity;
		
		public Solution (ArrayList <Item> items, int capacity) {
			this.items = items;
			this.capacity = capacity;
		}
		
		public abstract void solve();
		
		public ArrayList<Item> getItem() 
		{
			return items;
		}
		
		public int getCapacity()
		{
			return capacity;
		}
		
		public void disCurrentItem() {
			System.out.println("NAME\t\t\tWEIGHT\t\t VALUE\n");
			for(int i = 0; i < items.size(); i++) 
			{
	            System.out.printf("%-16s %13d %15d",items.get(i).getName(),items.get(i).getWeight(),items.get(i).getValue());
	            System.out.print("\n");
			}
		}
}
