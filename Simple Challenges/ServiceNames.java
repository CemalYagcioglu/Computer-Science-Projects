import java.util.*;
public class ServiceNames {
	public String[] makeList(String[] services) {
		Arrays.sort(services);
		Set<String> rest = new HashSet<String>();
		Set<String> first = new HashSet<String>();
		ArrayList<String> caps = new ArrayList<String>();
		ArrayList<String> sent = new ArrayList<String>();
		for(String str: services) {
			String[] w = str.split("\\s+");
			first.add(w[0]);
			for(int i=1; i<w.length; i++) {
				rest.add(w[i]);
			}
		}
		for(String str2: rest) {
			caps.clear();
			for(String str3: services) {
				String[] wo = str3.split("\\s+");
				ArrayList<String> wf = new ArrayList<String>();
				for(int l=0; l<wo.length-1; l++) {
					wf.add(wo[l+1]);
				}
				if(str3.indexOf(str2)!=-1 & wf.contains(str2)) {
					
					caps.add(wo[0]);
					
				}
			}
			String s = str2 + " ==> " + String.join(", ", caps);
			sent.add(s);
		}	

		String[] finalL = new String[sent.size()];
		finalL = sent.toArray(finalL);
		Arrays.sort(finalL);
		return finalL;
    }
}