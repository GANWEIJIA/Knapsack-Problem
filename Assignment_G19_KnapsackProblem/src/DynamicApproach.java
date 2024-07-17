import java.util.ArrayList;
public class DynamicApproach extends Solution {
	
	public DynamicApproach(ArrayList <Item> items, int capacity)
	{
		super(items, capacity);
	}
	public void solve()
	{
		ArrayList <Item> items = this.getItem();
		int capacity = this.getCapacity();
	
		int [][] dp = new int [items.size()+1][capacity+1]; //5 //5001
		
		for (int i =1; i< items.size()+1 ; i++) {	//size =5
			for (int n = 1; n < capacity+1; n++)
			{	
				if (items.get(i-1).getWeight() <= n)
					dp[i][n] = Math.max(dp[i-1][n], items.get(i-1).getValue()+
							dp[i-1][n - items.get(i-1).getWeight()]);
				else
					dp[i][n] = dp [i-1][n];
			}
		}
		System.out.println("\nCAPACITY\t\t" + capacity);
		System.out.println("MAXIMUM VALUE THAT CAN BE OBTAINED:  " + dp[items.size()][capacity]);
	    
		int remainCap = capacity;
		System.out.println("\nSELECTED ITEMS: ");
		 for (int i = items.size(); i > 0 && dp[i][remainCap] > 0; i--) {
	            if (dp[i][remainCap] != dp[i - 1][remainCap]) {
	                System.out.println(items.get(i-1).getName());
	                remainCap -= items.get(i-1).getWeight();
	            }
	        }
		 System.out.println();      
	}
}
