import java.util.*;
public class BruteWords {
    public int getScore(String str){
    		Map<String,Integer> counter = new HashMap<String,Integer>();
        String[] input = str.split("");
        int result = 0;
        List<Integer> count = new ArrayList<Integer>();
        for(String in: input) {
        		if(!counter.containsKey(in)) {
        			counter.put(in, 0);
        		}
        		counter.put(in, counter.get(in)+1);
        		
        		
        }
        for(Map.Entry<String,Integer> entry: counter.entrySet()) {
        		count.add(entry.getValue());
        }
        int csize = count.size();
        if((csize>1)) {
        		
        		System.out.println(str + "      ");
        		Collections.sort(count);
        		int max = count.get(csize-1);
        		int secondmax = count.get(csize-2);
        		count.add(max+secondmax);
        		count.remove(csize-1);
        		System.out.println(count + "      ");
        		System.out.println(csize-2);
        		count.remove(csize-2);
        }
        for(int c: count) {
        		result += c*c;
        }
       return result;
    }
}
