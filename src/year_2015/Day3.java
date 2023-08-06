package year_2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day3 {

    public static void main(String[] args)
    {
        singleSanta();
        multiSanta();
        return;
    }


    private static void singleSanta()
    {
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(".\\data\\year_2015\\day_3\\input.txt"));
            line = br.readLine();
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HashMap <String, Integer> hashMap = new HashMap<>(500);
        //String houseId = "houseXY";
        //System.out.println(houseId);
        //houseId.replace(5, 7, "11");
        //System.out.println(houseId);
        
        int x,y; x=y=0;
        String houseId = "house_[0,0]";
        hashMap.put(houseId, 1);
        for (int k=0; k< line.length(); ++k) {
            switch (line.charAt(k)) {
                case '^':
                    houseId="house_[" + Integer.toString(x) + "," + Integer.toString(++y) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;
                    //houseId.replace(5,7, Integer.toString(++x) + Integer.toString(y));

                case 'v':
                    houseId="house_[" + Integer.toString(x) + "," + Integer.toString(--y) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;
                
                case '>':
                    houseId="house_[" + Integer.toString(++x) + "," + Integer.toString(y) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;
                
                case '<':
                    houseId="house_[" + Integer.toString(--x) + "," + Integer.toString(y) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;

                default:
                    break;
            }
        }

        //System.out.println(hashMap);
        System.out.println("singleSanta(): The size of the hashMap is " + hashMap.size() + " entries");
        return;
    }


    private static void multiSanta()
    {
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(".\\data\\year_2015\\day_3\\input.txt"));
            line = br.readLine();
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HashMap <String, Integer> hashMap = new HashMap<>(500);
        boolean originalSantasTurn = true;
        int x,y; x=y=0;
        int rx, ry; rx=ry=0;
        String houseId = "house_[0,0]";
        hashMap.put(houseId, 2);
        for (int k=0; k< line.length(); ++k) {
            switch (line.charAt(k)) {

                case '^':
                    houseId = originalSantasTurn ? "house_[" + Integer.toString(x) + "," + Integer.toString(++y) + "]" :
                                                   "house_[" + Integer.toString(rx) + "," + Integer.toString(++ry) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;

                case 'v':
                    houseId = originalSantasTurn ? "house_[" + Integer.toString(x) + "," + Integer.toString(--y) + "]" :
                                                   "house_[" + Integer.toString(rx) + "," + Integer.toString(--ry) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;
                
                case '>':
                    houseId = originalSantasTurn ? "house_[" + Integer.toString(++x) + "," + Integer.toString(y) + "]" :
                                                   "house_[" + Integer.toString(++rx) + "," + Integer.toString(ry) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;
                
                case '<':
                    houseId = originalSantasTurn ? "house_[" + Integer.toString(--x) + "," + Integer.toString(y) + "]" :
                                                   "house_[" + Integer.toString(--rx) + "," + Integer.toString(ry) + "]";
                    hashMap.put(houseId, hashMap.getOrDefault(houseId, 0) + 1);
                    break;

                default:
                    break;
            }
            originalSantasTurn = (originalSantasTurn == true) ? false : true;
        }

        System.out.println("multiSanta(): The size of the hashMap is " + hashMap.size() + " entries");
    }


}
