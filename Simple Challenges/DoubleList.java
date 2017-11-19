public class DoubleList {
	public ListNode bigify(ListNode list) {
			 if(list==null) {
				 return null;
			 }
			 ListNode current = new ListNode(list.info);
			 ListNode ans = current;
			 while(list!=null) {
			 	for(int i=0;i<2;i++) {
			 		current.next = new ListNode(list.info);
			 		current = current.next;
			 	}
			 list = list.next;
			 }
			 return ans.next;
	}
}
