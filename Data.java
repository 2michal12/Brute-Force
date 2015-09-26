package nks1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michal 8822
 */
public class Data {
    
    public String[] wordsLoad(String file) throws IOException{
        ArrayList<String> wList = new ArrayList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        while(true){
            String adj = reader.readLine();
            if( adj == null) break;
            wList.add(adj);
        }
        reader.close();
        
        String[] wArray = wList.toArray(new String[0]);
        return wArray;
    }
    
    public String[] parsePWDlist(String file, String userName, int count) throws IOException{
        String[] pwdArray = new String[count];
        int pwdIndex = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        while(true){
            String pwdLine = reader.readLine();
            if( pwdLine == null) break;
            if( pwdLine.contains(userName) ){
                String[] tmpArr = pwdLine.split("'");
                pwdArray[pwdIndex] = tmpArr[3];
                pwdIndex++;
            }
        }
        
        return pwdArray;
    }
 
}
