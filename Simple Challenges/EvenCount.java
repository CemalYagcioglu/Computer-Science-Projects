import java.util.*;
public class EvenCount {
    public int count (ListNode list){
    		HashSet<Integer> uniques = new HashSet<Integer>();
    		int counter = 0;
        // replace statement below with code you write
    		while(list!=null) {
    			if(!uniques.contains(list.info) && list.info%2==0) {
    				counter+=1;
    				uniques.add(list.info);
    			}
    			list = list.next;
    		}
        return counter;
    }
}
