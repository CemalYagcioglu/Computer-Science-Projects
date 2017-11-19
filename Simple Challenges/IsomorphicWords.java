import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.*;

public class IsomorphicWords {
	public int countPairs(String[] words) {
		int counter = 0;
		String[] str = new String[words.length];
		for(int i=0;i<words.length;i++) {
			Map<Character, Integer> CharC = charCounting(words[i]);
			for(Map.Entry<Character,Integer> entry: CharC.entrySet()) {
				if(entry.getValue()!=0){
					if(i==0) {
						str[i] = Integer.toString(entry.getValue());
					}
					else {
						str[i] += Integer.toString(entry.getValue());
				}
				System.out.println(str[i]);
			}
				
			//Arrays.sort(a);//stack over flow
			//for(int k=0;k<a.length;k++) {
			//	str[i] += Integer.toString(a[k]);
			//}
		}

		for(int j=0; j<str.length;j++) {
			for(int l=0; l>j; l++ ) {
				if(str[j].equals(str[l])){
					counter +=1;
				}
			}
		}
			
			
			
			
			
		
		return counter;
	}
	
    private Map<Character, Integer> charCounting(String stringInp){
	  	stringInp.toLowerCase().replaceAll("\\s+", "");
	  	Map<Character, Integer> CharCount = new HashMap<Character, Integer>();
	  	for(char c = 'a'; c< ('z'+1); c++) {
	  		CharCount.put(c,0);
	  	}
	  	for(char c : stringInp.toCharArray()) {
  		if(! CharCount.containsKey(c)) {
  			CharCount.put(c, 0);
      	}
      	CharCount.put(c, CharCount.get(c)+1);
      	
	  	}
	  	return CharCount;
  
  }
}

