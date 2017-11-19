
public class RemoveDupes {
    public ListNode remove (ListNode list) {
    		if(list==null) return null;
    		ListNode first = list;
    		//ListNode first = answer;
    		while(list.next!=null) {
    			if(!(list.next.info==list.info)) {
    			
    				//answer = list.next;
    				list = list.next;		
    			}
    			else {
    				list.info = list.next.info;
    				list.next = list.next.next;
    			}
    		}
        // replace statement below with code you write
	  return first;
    }
}
