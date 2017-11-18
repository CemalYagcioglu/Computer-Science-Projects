import java.util.*;
import java.awt.Point;
/**
 * Compute statistics on Percolation after performing T independent experiments on an N-by-N grid.
 * Compute 95% confidence interval for the percolation threshold, and  mean and std. deviation
 * Compute and print timings
 * 
 * @author Kevin Wayne
 * @author Jeff Forbes
 * @author Josh Hug
 */

public class PercolationStats {
   
	public static int RANDOM_SEED = 1234;
	public static Random ourRandom = new Random(RANDOM_SEED);
	protected IPercolate myObject;
	public double[] ratios;
	public double givenTTotalOpenNumber = 0.0;
	public static int Nno;
	public static int Tno;
	IUnionFind finder = new QuickFind(); ///???
	
	public PercolationStats(int N, int T) {
		if(N<=0 || T<=0) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		ratios = new double[T];
		Tno = T;
		Nno = N;
		for(int i=0;i<T;i++) {

			//myObject = new PercolationDFS(N);
			//myObject = new PercolationDFSFast(N);  
			myObject = new PercolationUF(N, finder); //QuickFind and QuickUWPC
			ArrayList<Point> randomPointLis = new ArrayList<Point>();
			for(int q=0;q<N;q++) {
				for(int w=0;w<N;w++) {
					randomPointLis.add(new Point(q,w));
				}
			}
			
		    Collections.shuffle(randomPointLis,ourRandom);
		    //for(int y=0;y<(N*N);y++) {
		    int y=0;
		    while(myObject.percolates()==false & y<(N*N)) {
				int rowNo = randomPointLis.get(y).x;
				int colNo = randomPointLis.get(y).y;
				myObject.open(rowNo,colNo);
				y+=1;
				}
			
			ratios[i] += myObject.numberOfOpenSites()/(((double) N)*N);
		}

	}
	public static void main(String[] args) {
		double start = System.nanoTime();
		PercolationStats ps = new PercolationStats(Nno,Tno); 
		double end = System.nanoTime();
		double time = (end-start)/1e9;
		System.out.printf("mean: %1.4f, stddev: %1.4f, confidence Low %1.4f, " +
				"confidence High, time: %1.4f\n"+
				ps.mean(),ps.stddev(),ps.confidenceLow(),
				ps.confidenceHigh(),time);
	}
	
	public double mean() {
		return StdStats.mean(this.ratios);
	}
	public double stddev() {
		return StdStats.stddev(this.ratios);
	}
	public double confidenceLow() {
		return this.mean()-(1.96*this.stddev()/Math.sqrt(Tno));
	}
		
	public double confidenceHigh()	{
		return this.mean()+(1.96*this.stddev()/Math.sqrt(Tno));
	}
}
