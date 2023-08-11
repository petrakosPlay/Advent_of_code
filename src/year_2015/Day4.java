package year_2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
    
    private static final String HASH_ALGORITHM = "MD5";
    private static final String SECRET_KEY = "bgvyzdsv";
    private static final String PREFIX = "000000";

    public static void main(String[] args) {
        
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("No such algorithm: " + HASH_ALGORITHM + ". Exiting...");
            return;
        }

        /*String input, md5Hash;
        int i = 1;
        while(true){
            input = SECRET_KEY + Integer.toString(i);
            md5Hash = toHexString(md.digest(input.getBytes()));
            if (md5Hash.startsWith("000000"))
                break;
            i++;
        }*/

        int i = 0;
        while ( (toHexString(md.digest((SECRET_KEY+i).getBytes()))).startsWith(PREFIX) == false)  ++i;
        System.out.println("Answer is : " + i);    

    }
    
    private static String toHexString (byte[] messageDigest) {
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < messageDigest.length; i++) {
            if ((0xff & messageDigest[i]) < 0x10) {
            sb.append('0');
            }
            sb.append(Integer.toHexString(0xff & messageDigest[i]));
        }
        return sb.toString();
    }
    
}
