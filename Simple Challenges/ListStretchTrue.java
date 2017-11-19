
public class ListStretchTrue {
    public ListNode stretch (ListNode list, int amount){
    		if(list!=null) {
		ListNode listNo = new ListNode(list.info);
    		ListNode first = listNo;
    		while(list!=null) {
    			
    			listNo.next= new ListNode(list.info);
    			listNo = listNo.next;
    			for(int i=0;i<amount-1;i++) {
    				listNo.next = new ListNode(list.info);
    				listNo = listNo.next;
    			}
    			list = list.next;
    			
    		}
    			
    		first = first.next;
    		
        return first;
    		}
    		return null;
    }
    //public ListNode stretch (ListNode list, int amount){
    //    // replace statement below with code you write
	//	ListNode first = new ListNode(list.info);
	//	ListNode finals = first;
    //		while(list.next!=null) {
    //			//ListNode first = new ListNode(list.info);
    //			for(int i=0;i<amount;i++) {
    //				finals.next = new ListNode(list.info,finals);
    //			}
    //			list = list.next;
    //			finals = new ListNode(list.info,finals);
    //		}
    			
    		
    //    return finals;
    //}
}
