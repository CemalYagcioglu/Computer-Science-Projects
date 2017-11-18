
public class Listo {
	public ListNode first;
    public ListNode stretch (ListNode list, int amount){
        // replace statement below with code you write
    		//ListNode first = list;
    		ListNode listNo = new ListNode(list.info);
    		while(list.next!=null) {

    			for(int i=0;i<amount;i++) {
    				listNo.next = new ListNode(list.info,list.next);
    			}
    			list = list.next;
    			listNo.next = new ListNode(list.info,listNo);
    		}
    			
    		
        return list;
    }
}
