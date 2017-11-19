
public class RemoveMin {
    public ListNode remove (ListNode list) {
    		ListNode current = new ListNode(list.info);
    		ListNode minNode = list;
    		ListNode first = current;
    		int min = 51;
    		while(minNode!=null) {
    			if(min>minNode.info) {
    				min = minNode.info;
    			}
    			minNode = minNode.next;
    		}
    		System.out.println("NEW");
    		System.out.println("Min val: "+min);
    		while(current!=null) {
    			
    			System.out.println(list.info);
    			if(min==list.info) {
    				list = list.next;
    				current = current.next;
    				
    			}
    			else {
    				current.next = new ListNode(list.info);
    			}
    			current = current.next;
    			list = list.next;
    			
    		}
    				
    		
	return first.next;
    }
}