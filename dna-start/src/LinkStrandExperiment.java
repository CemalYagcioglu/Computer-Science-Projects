import java.util.ArrayList;
import java.util.Collections;

public class LinkStrandExperiment {
	public static void main(String args[]) {
		String original = "CGA";
		String evolved = "GGGTTTAAA";
		String repeatingPiece = "x";
		double dnaLength = 6*Math.pow(10,5);
		ArrayList<String> StringCollection = new ArrayList<String>(); //b is equal to index*2
		for(int b=1; b<Math.pow(10, 5); b*=2) {
			StringBuilder dna = new StringBuilder();
			ArrayList<Integer> randomList = new ArrayList<Integer>();
			for(int i=0; i<b;i++) {
				randomList.add(1);
			}
			for(int i=0; i<(dnaLength-b*original.length());i++) {
				randomList.add(0);
			}
			Collections.shuffle(randomList);
			for(int i=0;i<((dnaLength-b*original.length())+b);i++) {
				if(randomList.get(i)==1) {
					dna.append(original);
				}
				else {
					dna.append(repeatingPiece);
				}
			}
			StringCollection.add(dna.toString());
			
		}
		
		System.out.println("LinkStrand");
		for(int i=0; i<StringCollection.size();i++) {
			int bNo = (int) Math.pow(2, i);
			int NumTrials = 4;
			String dnaString = StringCollection.get(i);
			double totalTime = 0.0;
			for(int trialNo=0; trialNo<NumTrials; trialNo++) {
				IDnaStrand strand = new LinkStrand(dnaString);
			    double start = System.nanoTime();
			    strand.cutAndSplice(original, evolved);
			    totalTime += (System.nanoTime() - start) / 1e9;
			}
			totalTime = totalTime/NumTrials;
			System.out.printf("%6d\t%6.4f\n", bNo, totalTime);
		  
		}
		String evolved2 = "AAGGGTTTAAAGGTATGATGATGATAGATGGAAAATTTTGGAGATGAGTA";
		String longEvolved = evolved2+evolved2+evolved2;
		System.out.println("");
		System.out.println("StringBuilderStrand Changing Splice");
		for(int k=1; k<longEvolved.length();k++) {
			String evolvedInp = longEvolved.substring(0, k);
	
			for(int i=0; i<StringCollection.size();i++) {
				int bNo = (int) Math.pow(2, i);
				int NumTrials = 4;
				String dnaString = StringCollection.get(i);
				double totalTime = 0.0;
				for(int trialNo=0; trialNo<NumTrials; trialNo++) {
					IDnaStrand strand = new LinkStrand(dnaString);
				    double start = System.nanoTime();
				    strand.cutAndSplice(original, evolvedInp);
				    totalTime += (System.nanoTime() - start) / 1e9;
				}
				totalTime = totalTime/NumTrials;
				if(bNo==65536) {
					System.out.printf("%6d\t%6.4f\n", k, totalTime);
				}
			}
		}
		

	}
}
