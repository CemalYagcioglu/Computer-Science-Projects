import java.util.*;
public class EqualCommon {
    public String[] matches(String[] a1, String[] a2) {
        Map<String,Integer> a1M = new HashMap<String,Integer>();
        Map<String,Integer> a2M = new HashMap<String,Integer>();
        List<String> finalList = new ArrayList<String>();
        for(String str : a1) {
        		if(!a1M.containsKey(str)) {
        			a1M.put(str, 0);
        		}
        			a1M.put(str, a1M.get(str)+1);
        }
        for(String str2 : a2) {
    		if(!a2M.containsKey(str2)) {
    			a2M.put(str2, 0);
    		}
    			a2M.put(str2, a2M.get(str2)+1);
        }
        for(String elements : a1M.keySet()) {
        		if(a1M.get(elements)==a2M.get(elements)) {
        			finalList.add(elements);
        		}
        }
        Collections.sort(finalList);
        String[] final1 = finalList.toArray(new String[finalList.size()]);
        return final1;
    }
}
