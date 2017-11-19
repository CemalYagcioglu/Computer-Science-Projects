
public class AddSome22 {
    public ListNode splice(ListNode list, int size){
    		ListNode current = new ListNode(list.info,list.next);
    		ListNode begin = new ListNode(list.info,null);
    		ListNode starter = begin;
    		int counter1=0;
    		while(list!=null && counter1<size) {
    			begin.next = list.next;
    			list = list.next;
    			begin = begin.next;
    			counter1+=1;
    		}
    		while(current!=null) {
    			
    			begin.next = current;
    			begin = begin.next;
    			current = current.next;
    			
    		}
        return starter;
    }
}
