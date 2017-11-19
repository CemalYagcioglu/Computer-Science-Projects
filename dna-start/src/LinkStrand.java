
public class LinkStrand implements IDnaStrand{
	private class Node {
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}
	private Node myFirst,myLast;
	private long mySize;
	private int myAppends;
	private int myIndex,myLocalIndex;
	private Node myCurrent;
	
	public LinkStrand() {
		this("");
	}
	public LinkStrand(String s) {
		initialize(s);
	}
	@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize += dna.length();
		myAppends += 1;
		//myLast.next = new Node(myLast.info+dna);
		//myLast = myLast.next;
		//mySize += dna.length();
		//myAppends+=1;
		return this;
	}
	@Override
	public String toString() {
		Node current = myFirst;
		String ret = current.info;
		while(current.next!=null) {
			ret += current.next.info;
			current = current.next;
		}
		return ret;
	}
	@Override
	public void initialize(String source) {
		myAppends = 0;
		mySize = source.length();
		myFirst = new Node(source);
		myLast = myFirst;
		myIndex = -1;
		myLocalIndex = -1;
		Node myCurrent;
	}
	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}
	@Override
	public long size() {
		return this.mySize;
	}
	@Override
	public int getAppendCount() {
		return this.myAppends;
	}
	@Override
	public IDnaStrand reverse() {
		StringBuilder copy = new StringBuilder(myLast.info);
		copy.reverse();
		LinkStrand ss = new LinkStrand(copy.toString());
		//Node current = ss.myFirst;
		//Node prevN = null;
		//Node nextN = null;
		//while(current.next!=null) {
		//	nextN = current.next;
		//	current.next = prevN;
		//	prevN = current;
		//	current = nextN;
		//}
			
			
		return ss;
	}
	@Override
	public char charAt(int index) {
		if(index>myIndex && myIndex>0) {  //Further in order and myIndex has value
			if(myCurrent.info.length()>(index-(myIndex-myLocalIndex))){ 
				//In the same node
				myIndex = index;
				myLocalIndex = index-(myIndex-myLocalIndex);
				return myCurrent.info.charAt(index);
			}
			else {  //in the next nodes
				int remaining = index-(myIndex-myLocalIndex);
				myCurrent = myCurrent.next;
				while(remaining>myCurrent.info.length()-1) {
					remaining -= myCurrent.info.length();
					myCurrent = myCurrent.next;
					
				}
				return myCurrent.info.charAt(remaining);
			}
		}
		else {
			Node myCurrent = myFirst;
			int remaining = index;
			while(remaining>myCurrent.info.length()-1) {
				remaining -= myCurrent.info.length();
				myCurrent = myCurrent.next;
				
			}
			
			return myCurrent.info.charAt(remaining);
			
				
			}
		}
}
