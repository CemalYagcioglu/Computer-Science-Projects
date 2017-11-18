import java.util.*;

public class EfficientMarkov extends MarkovModel{
	private Map<String,ArrayList<String>> myMap;// = new HashMap<String,ArrayList<String>>();
	public EfficientMarkov(int order) {
		super(order);
		myRandom = new Random(RANDOM_SEED);
		
		myMap = new HashMap<String,ArrayList<String>>();
		
	}
	public void setTraining(String text) {
		myMap.clear();
		myText = text;
		for(int i=0;i<(text.length()-(myOrder));i++) {
			

			String keytext = text.substring(i, i+myOrder);
			if(!myMap.containsKey(keytext)){
				ArrayList<String> valueList = new ArrayList<String>();
				valueList.add(text.substring(i+(myOrder),i+(myOrder+1)));
				
				myMap.put(keytext, valueList);

			}
			else {
				ArrayList<String> valueList = new ArrayList<String>();

				valueList = myMap.get(keytext);

				valueList.add(text.substring(i+(myOrder),i+(myOrder+1)));

				myMap.put(keytext, valueList);
			}
			
		}
		ArrayList<String> valueList2 = new ArrayList<String>();
		valueList2 = myMap.get(text.substring(text.length()-myOrder,text.length()));
		if(valueList2==null) {
			ArrayList<String> empty = new ArrayList<String>();
			empty.add(PSEUDO_EOS);
			myMap.put(text.substring(text.length()-myOrder,text.length()), empty);
			
		}
		else {
			valueList2.add(PSEUDO_EOS);
			myMap.put(text.substring(text.length()-myOrder,text.length()), valueList2);
			
		}


	}
	public ArrayList<String> getFollows(String key){

		if(!myMap.containsKey(key)){

			throw new NoSuchElementException();
		}
		else {
		return myMap.get(key);
		}
	}

}
