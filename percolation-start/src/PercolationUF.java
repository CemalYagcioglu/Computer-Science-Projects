import java.util.Arrays;

public class PercolationUF implements IPercolate {
	protected int[][] myGrid;
	protected IUnionFind myFinder;
	protected int myOpenCount;
	private final int VTOP;
	private final int VBOTTOM;

	
	public PercolationUF(int size, IUnionFind finder) {
		myGrid = new int[size][size];
		myOpenCount = 0;
		VTOP=size*size+1;
		VBOTTOM=size*size;
		for (int[] row : myGrid) {
			Arrays.fill(row, BLOCKED);
		}
		myFinder = finder;
		myFinder.initialize(size*size+2);
		//IUnionFind myFinderIns = myFinder; //??
	}
	@Override
	public boolean isOpen(int row,int col) {
		if(!inBounds(row,col)){
			throw new IndexOutOfBoundsException("Input is out of bonds *");
		}
		return myGrid[row][col] != BLOCKED;
	}
	@Override
	public boolean isFull(int row, int col) {
		if(!inBounds(row,col)){
			throw new IndexOutOfBoundsException("Input is out of bonds *");
		}
		int ind = getIndex(row,col);
		return myFinder.connected(ind, VTOP);
	}
	protected int getIndex(int row, int col) {
		return row*myGrid[0].length+col;
	}
	
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
	protected void updateOnOpen(int row, int col) {
		int[] c = new int[]{1,-1,0,0,0,0,1,-1};
		int ind = getIndex(row,col);
		
		if(inBounds(row,col)){
			if(row==0) {
				myFinder.union(ind,VTOP);
			}
			if(row==(myGrid.length-1)){
				myFinder.union(ind, VBOTTOM);
			}
		}
		else {
			throw new IndexOutOfBoundsException("Input is out of bonds *");
		}
		
		for(int i=0;i<4;i++) {
			if(inBounds(row+c[i],col+c[i+4])&&(isOpen(row+c[i],col+c[i+4]))) {
				int ind2 = getIndex(row+c[i],col+c[i+4]);
				myFinder.union(ind,ind2);
			}
		}

			
		
	}
	@Override
	public void open(int row, int col) {
		if(!inBounds(row,col)){
			throw new IndexOutOfBoundsException("Input is out of bonds *");
		}
		if (myGrid[row][col] != BLOCKED) {
			return;
		}
		myOpenCount += 1;
		myGrid[row][col] = OPEN;
		if (row == 0) {
			myGrid[row][col]	 = FULL;
		}
		updateOnOpen(row,col);
	}
	
	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}
	
	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	

}
