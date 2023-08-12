package year_2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        System.out.println("Found " + niceStringCount + " nice strings for part 1");

        niceStringCount=0;
        for (String line : lines) {
            //if (containsPair(line, 2) && hasDuplicateCharacter2(line))  {niceStringCount++; System.out.println(line);}
            if (containsDoublePair(line) && hasDuplicateCharacter2(line)) {  niceStringCount++;  System.out.println(line);}
        }
        System.out.println("Found " + niceStringCount + " nice strings for part 2");



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

    private static boolean hasDuplicateCharacter2 (String word) {
        for (int i=0; i<word.length()-2; ++i){
            if(word.charAt(i) == word.charAt(i+2))
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


    /* This funvtion has an error
    private static boolean containsPair (String word, int appearances) {
        HashMap <Character, Integer> hashMap = new HashMap<>();
        
        Character lastCharacter = ' ';

        for(int i=0; i<word.length()-1; ++i) {
            if(word.charAt(i) == word.charAt(i+1) && lastCharacter != word.charAt(i))
            {
                lastCharacter = word.charAt(i);
                hashMap.put(lastCharacter, hashMap.getOrDefault(lastCharacter, 0) + 1);
            }
            else lastCharacter = ' ';
        }

        for (Map.Entry <Character, Integer> map : hashMap.entrySet()) {
            if (map.getValue() >= appearances) return true;
        }
        return false;
    } */

    private static boolean containsPair (String word, int appearances) {
        HashMap <String, Integer> hashMap = new HashMap<>();
        
        String lastPair = " ";
        for(int i=0; i<word.length()-1; ++i) {
            if(!word.substring(i, i+2).equals(lastPair)) {
                lastPair = word.substring(i, i+2);
                hashMap.put(lastPair, hashMap.getOrDefault(lastPair, 0) + 1);
            } 
            else lastPair = " ";
        }

        for (Map.Entry <String, Integer> map : hashMap.entrySet()) {
            if (map.getValue() >= appearances)  return true;
        }
        return false;
    }
    
    private static boolean containsDoublePair (String word) {

        for(int i=0; i< word.length()-3; ++i) {
            if (word.indexOf(word.substring(i, i+2), i+2) >=0)
                return true;
        }
        return false;
    
    }

}
