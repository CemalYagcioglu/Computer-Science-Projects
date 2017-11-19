
public class ListNRev {
	public ListNode make(int n) {
		ListNode current = new ListNode(n);
		ListNode first = current;
		for(int i=n;i>0;i--) {
			for(int l=0;l<i;l++) {
				current.next = new ListNode(i);
				current = current.next;
			}
		}
    return first.next;
    }
}