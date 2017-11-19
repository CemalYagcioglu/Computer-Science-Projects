public class AddSome21 {
    public ListNode splice(ListNode list, int size){
    		ListNode firstCount = list;
    		ListNode first = list;
    		ListNode result = list;
    		ListNode current = new ListNode(list.info,null);
    		int counter = 1;
    		int counter2 = 1;
    		int length =0;
    		while(firstCount!=null) {
    			length+=1;
    			firstCount=firstCount.next;
    		}
    		while(first!=null && counter<size) {
    			current.next = first.next;
    			first = first.next;
    			current = current.next;
    		}
    		//list.next = null;
    		System.out.println("THIS IS IT");
    		System.out.println(length);
    		while(list!=null && counter2<length) {
    			System.out.println(counter2);
    			counter2+=1;
    			current.next = list.next;
    			list = list.next;
    			current=current.next;
    		}
    		System.out.println("ENDEND");
    		return result;
    }
}

