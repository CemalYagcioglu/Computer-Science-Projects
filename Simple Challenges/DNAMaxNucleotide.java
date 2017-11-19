
public class DNAMaxNucleotide {
	public String max(String[] strands, String nuc) {
		int len = strands.length;
		int counter2=-1;
		int maxi = -1;
		int maxlen = -1;
		for(int i=0; i<len; i++) {
	
			String[] list = strands[i].split("");
			int counter = 0;
			for(String letter : list) {
				if(letter.equals(nuc)) {
					counter++;
				}
				if(counter>counter2 || (counter==counter2 && maxlen<list.length)){

					maxi = i;
					counter2 = counter;
					maxlen = list.length;
				}
			}
		}
		if(counter2>0) {
			return strands[maxi];
		}
		
		return "";
	}

}
