package year_2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class Day5 {
    
    private static int NUMBER_OF_VOWELS = 3;
    private static Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
    private static Set<String> illegalSequenceSet = Set.of("ab", "cd", "pq", "xy");

    public static void main(String[] args) {
        
        int niceStringCount = 0;
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(".\\data\\year_2015\\day_5\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        for (String line : lines) {
            if (containsVowel(line, NUMBER_OF_VOWELS) && hasDuplicateCharacter(line) && !containsIlleagalSequence(line, illegalSequenceSet))
                niceStringCount++;
        }
        System.out.println("Found " + niceStringCount + " nice strings");

        /*String test = "ejfegabmaab";
        System.out.println(containsVowel(test, NUMBER_OF_VOWELS));
        System.out.println(hasDuplicateCharacter(test));
        System.out.println(illegalSequenceSet.toString());
        System.out.println(containsIlleagalSequence(test, illegalSequenceSet));
        System.out.println(illegalSequenceSet.contains("ab"));
        System.out.println(test.substring(5, 6));
        */

    }

    
    private static boolean containsVowel(String word, int numberOfVowels) {
        int i, count=0;
        for (i=0; i<word.length() && count<numberOfVowels; ++i) {
            switch (word.charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
                default:
                    break;
            }
        }
        return count == numberOfVowels ? true : false;
        
    } 

    private static int vowelCount (String word) {
        int i, count=0;
        for (i=0; i<word.length(); ++i) {
            if(vowelsSet.contains(word.charAt(i)))
                count++;
        }
        return count;
    }

    private static boolean hasDuplicateCharacter (String word) {
        for (int i=0; i<word.length()-1; ++i){
            if(word.charAt(i) == word.charAt(i+1))
                return true;
        }
        return false;
    }

    private static boolean containsIlleagalSequence (String word, Set <String> illegalSequenceSet) {
        for (int i=0; i<word.length()-1; ++i) {
            //if (illegalSequenceSet.contains(word.charAt(i) + word.charAt(i+1) ))
            if (illegalSequenceSet.contains(word.substring(i, i+2)))
                return true;
        }
        return false;
        
    }

}
