package year_2015;

import java.io.IOException;
import java.lang.Character.Subset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day8 {
    

    private static List <String> stringLiterals;

    public static void main(String[] args) {
        
        try {
            stringLiterals = Files.readAllLines(Paths.get(".\\data\\year_2015\\day_8\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int count1 = 0;
        int count2 = 0;
        for(String s : stringLiterals) {
            count1+= codeRepresentationLengthOf(s) - inMemoryLengthOf(s);
            //see how to remove leading and trailing " from string using regex s.substring(1, s.length()-2) 
            //System.out.println("The code representation length of '" + s + "' is: " + codeRepresentationLengthOf(s));
            //System.out.println("The in-memory representation length of " + s + " is: " + inMemoryLengthOf(s));    
            //System.out.println(s + " " + (encodedRepresentationLengthOf(s)));
            count2+= encodedRepresentationLengthOf(s) - codeRepresentationLengthOf(s);
        }
        System.out.println(count1);
        System.out.println(count2);
    }


    private static int codeRepresentationLengthOf(String s) {
        return s.length();
    }

    private static int inMemoryLengthOf(String s) {

        if (s.length() <= 2)    return 0;

        int count = 0;
        for(int i = 1; i < s.length() - 1 ; ++i) {
            count++;
            if (s.charAt(i) == '\\' && i < s.length() - 2) {
                if(s.charAt(i + 1) == 'x')      i+=3;
                else                            i+=1;
            }
        }
        return count;
    }

    private static int encodedRepresentationLengthOf(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '\"' || s.charAt(i) == '\\')  count+=2;
            else                                            count++;
        }
        return count + 2;
    }

}
