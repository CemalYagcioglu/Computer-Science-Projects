import java.util.*;

public class ClassScores {
	public int[] findMode(int[] scores) {
		int max = -1;
		ArrayList<Integer> countT = new ArrayList<Integer>();
		Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
		for(int i:scores) {
			if(! counts.containsKey(i)) {
				counts.put(i,0);
			}
			counts.put(i, counts.get(i)+1);
		}
		for(int i:counts.keySet()) {
			int c = counts.get(i);
			if(c==max) {
				countT.add(i);
			}
			if(c>max) {
				max=c;
				countT.clear();
				countT.add(i);
			}
		}
		
		int[] finala = new int[countT.size()];
		for(int i=0; i<countT.size();i++) {
			finala[i] = countT.get(i);
		}
		Arrays.sort(finala);
		return finala;
	}
}
