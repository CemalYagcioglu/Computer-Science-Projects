import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

public class EfficientWordMarkov extends WordMarkovModel{
	private int myOrder;
	private Map<WordGram,ArrayList<String>> myMap;
	public EfficientWordMarkov(int order) {
		super(order);
		myOrder = order;
		myRandom = new Random(RANDOM_SEED);
		
		myMap = new HashMap<WordGram,ArrayList<String>>();
		
	}
	@Override
	public void setTraining(String text) {
		myMap.clear();
		myWords = text.split("\\s+");
		
		//for(int i=0;i<myWords.length-myOrder;i++) {
		for(int i=0;i<myWords.length-(myOrder+1);i++) {
			WordGram wgz = new WordGram(myWords,i,myOrder);
			if(!myMap.containsKey(wgz)) {
				ArrayList<String> valueList = new ArrayList<String>();
				valueList.add(myWords[i+myOrder]);
				myMap.put(wgz,valueList);
			}
			else {
				ArrayList<String> valueList = new ArrayList<String>();
				valueList = myMap.get(wgz);
				valueList.add(myWords[i+myOrder]);
				myMap.put(wgz, valueList);
			}
			ArrayList<String> valueList2 = new ArrayList<String>();
			WordGram last = new WordGram(myWords,myWords.length-(myOrder+1),myOrder);
			valueList2 = myMap.get(last);
			if(valueList2==null) {
				ArrayList<String> empty = new ArrayList<String>();
				empty.add(PSEUDO_EOS);
				myMap.put(last, empty);
				
			}
			else {
				valueList2.add(PSEUDO_EOS);
				myMap.put(last, valueList2);
				
			}
		}
		
		
	}
	@Override
	public ArrayList<String> getFollows(WordGram wg){

		if(!myMap.containsKey(wg)){
			throw new NoSuchElementException();
		}
		else {
		return myMap.get(wg);
		}
	}

}
