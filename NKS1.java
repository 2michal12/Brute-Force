package nks1;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Michal 8822
 */
public class NKS1 {
    
    public static final String USER_NAME = "user8822";
    public static final int COUNT_PWD_FOR_USER = 99;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
        
        final String adj = "adj.txt";
        final String noun = "noun.txt";
        final String pwd = "pwdlist.txt";
        final String output = "output.txt";
        Data load = new Data();
        
        String[] arrAdj = load.wordsLoad(adj);
        String[] arrNoun = load.wordsLoad(noun);
                
        String[] arrNum = new String[1000];
        
        for(Integer i = 0; i < arrNum.length; i++){
            if(i.toString().length() < 3){
                if(i.toString().length() < 2)
                    arrNum[i] = "00"+i.toString();
                else
                    arrNum[i] = "0"+i.toString();
            }else{
                arrNum[i] = i.toString();
            }
        }
        
        String[] pwdArray = load.parsePWDlist(pwd, USER_NAME, COUNT_PWD_FOR_USER);

        System.out.println("Load data finish ...\nBruteforce attack START ...\n");
        Attack attack = new Attack();
        attack.bruteForce(arrAdj, arrNoun, arrNum, pwdArray, output, USER_NAME);
    
    }
    
}
