
public class ListStretch {
	 public ListNode stretch (ListNode list, int amount){
		 if(list==null) {
			 return null;
		 }
		 ListNode current = new ListNode(list.info);
		 ListNode ans = current;
		 while(list!=null) {
		 	for(int i=0;i<amount;i++) {
		 		current.next = new ListNode(list.info);
		 		current = current.next;
		 	}
		 list = list.next;
		 }
		 return ans.next;
	 }
}
