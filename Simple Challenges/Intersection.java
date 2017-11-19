import java.util.*;
public class Intersection {
    public String matches(String[] entries) {
    	Set<String> result = new HashSet<String>();
    	String rest = "";
        for(String entry: entries) {
        		Set<String> st = new HashSet<String>(Arrays.asList(entry.split(" ")));
        		result.addAll(st);
        }
        for(String entry: entries) {
    			Set<String> st = new HashSet<String>(Arrays.asList(entry.split(" ")));
    			result.retainAll(st);
        }
        List<String> fin = new ArrayList<String>(result);
        if(fin.size()>0) {
        		Collections.sort(fin);
        		String first = fin.get(0);
        		for(int i=1;i<fin.size();i++) {
        			rest += " "+fin.get(i);
        		}
        		return first+rest;
        }
        return "";
    }
        
}
