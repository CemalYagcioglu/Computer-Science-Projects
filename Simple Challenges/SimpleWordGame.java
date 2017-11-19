import java.util.*;

public class SimpleWordGame {
      public int points(String[] player, String[] dictionary) {
    	  	int scores = 0;
    	  	ArrayList<String> dict = new ArrayList<>(Arrays.asList(dictionary));
    	  	//Set<String> players = new HashSet<String>();
    	  	Set<String> scoredW = new HashSet<String>();
    	  	for(String str: player) {
    	  		scoredW.add(str);
    	  	}
    	  	for(String st: scoredW) {
    	  		if(dict.contains(st)) {
    	  		scores+= st.length()*st.length();
    	  		}
    	  	}
    	  return scores;
      }
  }