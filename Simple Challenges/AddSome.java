
public class AddSome {
    public ListNode splice(ListNode list, int size){
        ListNode current = new ListNode(list.info,null);
        ListNode result = current;
        //ListNode Pfirst = list;
        ListNode ilkpoint = list;
        int counter = 1;
        while(ilkpoint!=null && counter<size) {
        		current.next = new ListNode(ilkpoint.next.info,null);
        		current = current.next;
        		ilkpoint = ilkpoint.next;
        		counter+=1;
        }
        	while(list!=null) {
        		current.next = new ListNode(list.info,null);
        		current = current.next;
        		list = list.next;
        	}
        return result;
    }

}
