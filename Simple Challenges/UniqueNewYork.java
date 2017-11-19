import java.util.*;
public class UniqueNewYork {
    public int seen(String[] records) {
    		Set<String> setOfRec = new HashSet<String>();
    		for(String str : records) {
    			Set<String> news = new HashSet<String>(Arrays.asList(str.split(",")));
    			setOfRec.addAll(news);
    		}
        return setOfRec.size(); //replace with your code
    }
}
