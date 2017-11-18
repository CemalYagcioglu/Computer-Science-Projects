
public class PercolationDFSFast extends PercolationDFS{
	public PercolationDFSFast(int n) {
		super(n);
		
	}
	@Override
	public boolean isOpen(int row, int col) {
		if(!inBounds(row,col)) {
			throw new IndexOutOfBoundsException("Input is out of bonds 1");
		}
		else {
		return super.isOpen(row,col);
		}
	}
	@Override
	public boolean isFull(int row, int col) {
		if(!inBounds(row,col)) {
			throw new IndexOutOfBoundsException("Input is out of bonds 2");
		}
		else {
			return super.isFull(row,col);
		}
	}
	@Override
	public void open(int row, int col) {
		if(!inBounds(row,col)) {
			throw new IndexOutOfBoundsException("Input is out of bonds 3");
		}
		else {
			super.open(row,col);
		}

	}
	@Override
	public void updateOnOpen(int row, int col) {
		if(!inBounds(row,col)) {
			throw new IndexOutOfBoundsException("Input is out of bonds 4");
		}
		int[] r = new int[]{1,-1,0,0};
		int[] c = new int[]{0,0,1,-1};
		boolean bol =  (row==0);
		
		for(int i=0;i<4;i++) {
			bol = bol || (inBounds(row+r[i],col+c[i]) && isFull(row+r[i],col+c[i]));
		}
		if(bol==true) {
				myGrid[row][col] = FULL;
				dfs(row+1,col);
				dfs(row-1,col);
				dfs(row,col+1);
				dfs(row,col-1);
			
		}

		
		
	}
	
}
