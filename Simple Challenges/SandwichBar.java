import java.util.*;

public class SandwichBar {
	public int whichOrder(String[] available, String[] orders){
		int loa = orders.length;  //3
		
		for(int i = 0;i<loa;i++) {
			int counter = 0;
			String[] list1 = orders[i].split(" ");
			List<String> alist = Arrays.asList(list1);
			int len = list1.length;  //2
			for(String orderitem : alist) {
				if(Arrays.asList(available).contains(orderitem)) {
				counter++;
				
				}
			
		
		
			}
			if(counter==len) {
				return i;
			}
		}
		return -1;
	}

}

