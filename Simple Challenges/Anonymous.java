import java.util.*;


public class Anonymous {
	public int howMany(String[] headlines, String[] messages) {
		int countdown = 0;
    	  	Map<Character, Integer> headMap = charCounting(String.join("", headlines));
	  	countdown = messages.length;
        for(int i=0; i<messages.length; i++) {
        		Map<Character, Integer> messMap = charCounting(messages[i]);
        	  	for(char c = 'a'; c< ('z'+1); c++) {
        	  		if(headMap.get(c)<messMap.get(c)) {
        	  			countdown -= 1;
        	  			break;
        	  		}	
        	  	}
        	}
            
        return countdown;
      }
      public Map<Character, Integer> charCounting(String stringInput){
    	  	String stringInpu = stringInput.toLowerCase();
    	  	String stringInp = stringInpu.replaceAll("\\s+", "");
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
    	  	//System.out.println(CharCount);
    	  	return CharCount;
      
      }
}
