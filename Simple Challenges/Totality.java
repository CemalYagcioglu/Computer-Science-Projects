public class Totality {
	public int sum(int[] a, String stype) {
		int total = 0;
		int len = a.length;
		for(int i=0;i<len;i++)
		if( (stype.equals("odd") && i%2==1) || (stype.equals("even") && i%2==0) || (stype.equals("all"))) {
			total = total + a[i];
			
		
		
		}
	return total;
	}

}
