package year_2015;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Day1
{
    public static void main(String[] args)
    {
        BufferedReader br;
        String line;
        
        try {
            br = new BufferedReader(new FileReader(".\\data\\year_2015\\day_1\\input.txt"));
            line = br.readLine();
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (line==null)
        {
            System.out.println("The input file contains no data. Exiting...");
            return;
        }

        int floorNumber = 0;
        System.out.println("Input length is " + line.length() + " characters");

        for (int i=0; i< line.length(); ++i)
        {
            floorNumber = (line.charAt(i) == '(' ) ? ++floorNumber : --floorNumber;
            //if (line.charAt(i) == '(' floorNumber++;
            
            if (floorNumber == -1)  System.out.println("Entered basement at step " + (i+1));
        }
        System.out.println("Final floor number is " + floorNumber);
    
    }
}
