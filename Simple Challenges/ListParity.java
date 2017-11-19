
public class ListParity {
    public int count (ListNode list){
    		int counter=0;
    		int sum=0;
        while(list!=null) {
        		if(counter%2==0) {
        			sum+=list.info;
        		}
        list=list.next;
        	counter+=1;
        }
        return sum;
    }
}
