import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class challenge {

/*
 * Complete the function below.
 */
static String[] matchNames(String[] inputNames, String[] dmvRecords) {
    ArrayList<String> dmvRecordsList = new ArrayList<String>(Arrays.asList(dmvRecords));
    ArrayList<String> inputNamesList = new ArrayList<String>(Arrays.asList(dmvRecords));
    HashMap<String,String> dmvMap = new HashMap<String,String>();
    String[] output = new String[inputNames.length];
    int len = inputNames.length;
    int disAccepted = 2;
    //ArrayList<String> dmvName = new ArrayList<String>();
    //ArrayList<String> dmvAdress = new ArrayList<String>;

    for(String nameAdress: dmvRecords){
        String[] nameAdd = nameAdress.split(";"); //Check this
        //dmvName.add(nameAdd[0]);
        //dmvAdress.add(nameAdd[1]);
        //System.out.print(nameAdd[1]);
        dmvMap.put(nameAdd[0],nameAdd[1]);
    }
    //for(String name:inputNames){
    int count = 0;
    for(int n=0;n<len;n++){
    
    //while(count<len){
        String name = inputNames[n];
        if(dmvMap.containsKey(name)){
            //System.out.println(name);
            //int ind = inputNamesList.indexOf(name);
            //output[ind] = dmvMap.get(name);
            output[count] = dmvMap.get(name);
           // System.out.println("Adress=  " + dmvMap.get(name));
            count+=1;
        }
        else{
            for(Map.Entry<String,String> entry: dmvMap.entrySet()){
                int namesdis = strDistance(name,entry.getKey());
                if(namesdis<=disAccepted){
                    output[count]=entry.getValue();
                    count+=1;
                }
                
            }

        }
    
    }
    return output;
}
 
static int strDistance(String a, String b){
    int minDis = 100;
    int lenA = a.length();
    int lenB = b.length();
    int[][] dis = new int[lenA+1][lenB+1];
    
    for(int i=0;i<lenA;i++){
        dis[i][0]=i;
    }
    for(int k=0;k<lenB;k++){
        dis[0][k]=k;
    }
    for(int m=0;m<lenA;m++){
        char cA = a.charAt(m);
        for(int j=0;j<lenB;j++){
            char cB = b.charAt(j);
            //if characters are same, no increase in distance
            if(cA==cB){
                dis[m+1][j+1]=dis[m][j];
            }
            else{
                //three operations possible, we need the min
                int delete = dis[m+1][j]+1;
                int replace = dis[m][j]+1;
                int insert = dis[m][j+1]+1;
                
                if(delete<replace && delete<insert){
                    minDis = delete;
                }
                else{
                    if(replace<insert){minDis = replace;}
                    else{minDis = insert;}       
                } 
                dis[m+1][j+1]=minDis;
            }
            
        }
    }
    return dis[lenA][lenB];
}


}
