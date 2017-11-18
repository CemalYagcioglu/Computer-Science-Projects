import java.util.*;
public class WordGram implements Comparable<WordGram>{
	
	private int myHash;
	private String[] myWords;
	private Map<String, Integer> wordHash = new HashMap<String,Integer>();
	public WordGram(String[] words, int index, int size) {
		String[] words2 = new String[size];
		for(int l=0;l<size;l++) {
			words2[l] = words[index+l];
			
		}
		myWords = words2;

	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		int hashW = 0;

		for(int k=0; k<myWords.length;k++) {
			String gWord = myWords[k];
			if(!wordHash.containsKey(gWord)) {
				hashW = myWords[k].toString().hashCode()%100000  ;
				wordHash.put(gWord, hashW);
				hash += hashW*(Math.pow(k+1, 2));

			}
			else {
				hash += wordHash.get(gWord)*(Math.pow(k+1, 2));
			}
		}
		
		myHash=hash;
		return myHash;
	}
	
	@Override
	public String toString() {
		String strNew = String.join(" ", myWords);
		return strNew;
	}
	
	@Override
	public boolean equals(Object other) {
		if (! (other instanceof WordGram)) {
			return false;
		}
		if(this.compareTo((WordGram) other)!=0) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(WordGram wg) {

		int thislen = this.myWords.length;
		int wglen = wg.myWords.length;
		int minint = Math.min(thislen,wglen);
		for(int i=0; i<minint; i++) {
			if(this.myWords[i].hashCode()==wg.myWords[i].hashCode()) {
				continue;
			}
			else {
				int difference = this.myWords[i].hashCode()-wg.myWords[i].hashCode();
				return difference;
			}
		}
		return thislen-wglen;
	}
	
	public int length() {
		return this.myWords.length;
	}
	
	public WordGram shiftAdd(String last) {
		String[] shiftArr = new String[this.myWords.length];
		for(int i=0; i<(this.myWords.length-1);i++) {
			shiftArr[i] = this.myWords[i+1]; 
		}
		shiftArr[this.myWords.length-1] = last;
		return new WordGram(shiftArr,0,this.myWords.length);
	}
}
