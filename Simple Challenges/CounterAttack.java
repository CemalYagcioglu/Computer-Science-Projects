import java.util.*;
public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        Map<String,Integer> countmap = new HashMap<String,Integer>();
        String[] strs = str.split(" ");
        int[] results = new int[words.length];
        for(String look : strs) {
        		if(!countmap.containsKey(look)) {
        			countmap.put(look, 0);
        		}
        		countmap.put(look, countmap.get(look)+1);
        }
        for(int i=0;i<words.length;i++){
        		if(countmap.containsKey(words[i])) {
        			results[i] = countmap.get(words[i]);
        		}
        		else {
        			results[i] = 0;
        		}
        }
        return results;
    }
}
