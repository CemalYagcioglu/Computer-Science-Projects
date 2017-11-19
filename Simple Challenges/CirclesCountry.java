public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, 
            int x1, int y1, int x2, int y2) {
		int len = x.length;
		int counter = 0;
		for(int i=0;i<len;i++) {
			if(isInside(x1, y1, x[i], y[i], r[i]) ^ isInside(x2,
					y2, x[i], y[i], r[i])) {
				counter += 1;
			}
		}
		return counter;
	}
				// you write code here
		//yz326 
	

	
	public boolean isInside(int xg, int yg, int cxg, int cyg, int rg) {
		
		int dist = ((cxg - xg)*(cxg-xg) + (cyg - yg)*(cyg - yg));
		return (rg*rg)>dist;
		
	}
}
