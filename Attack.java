package nks1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Michal 8822
 */
public class Attack {
    public void bruteForce(String[] adj, String[] noun, String[] num, String[] pwdArray, String file, String user) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException{
        int progress = adj.length-1;
        int match = 0;
        String encodedHash;
        PrintWriter output = new PrintWriter(new FileWriter(file));
        for(int i = 0; i < adj.length-1; i++){
            for(int j = 0; j < noun.length-1; j++){
                for(int k = 0; k < num.length; k++){
                    encodedHash = encode(hash(user+adj[i]+noun[j]+num[k]));
                    if( findMatch(encodedHash, pwdArray) ){
                        output.write(adj[i] + noun[j] + num[k]+"\n");
                        System.out.println("pwd: "+ ++match+".  "+encodedHash); //show match
                    }
                }
            }
            System.out.println(progress--); //show progres
        }
        output.close();
    }
    
    private byte[] hash(String pwd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return (digest.digest(pwd.getBytes("UTF-8")));
    }
    
    private String encode(byte[] hash){
        return DatatypeConverter.printBase64Binary(hash);
    }
    
    private boolean findMatch(String decodeHash, String[] pwdArray){
        for(int i = 0; i < pwdArray.length; i++){
            if(decodeHash.equals(pwdArray[i])) return true;
        }
        return false;
    }
   
}
