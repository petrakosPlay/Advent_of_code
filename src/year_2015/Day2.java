package year_2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    
    public static void main(String[] args)
    {
        BufferedReader br;
        String line;
        String [] dimensions;
        int totalWrappingPaperSurface = 0;
        int ribbonSurface = 0;
        
        try {
            br = new BufferedReader(new FileReader(".\\data\\year_2015\\day_2\\input.txt"));
            while( (line = br.readLine()) != null)
            {
                dimensions = line.split("x");
                totalWrappingPaperSurface+=calculateWrappingPaperSurface(dimensions);
                ribbonSurface+=calculateRibbonSurface(dimensions);
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("The elves need to order a total of " + totalWrappingPaperSurface + " square feet of wrapping paper.");
        System.out.println("The elves need to order a total of " + ribbonSurface + " square feet of ribbon.");
    }

    private static int calculateWrappingPaperSurface(String[] dimensions)
    {
        int area_1 = Integer.parseInt(dimensions[0]) * Integer.parseInt(dimensions[1]);
        int area_2 = Integer.parseInt(dimensions[1]) * Integer.parseInt(dimensions[2]);
        int area_3 = Integer.parseInt(dimensions[2]) * Integer.parseInt(dimensions[0]);

        return 2 * (area_1 + area_2 + area_3) + Math.min(Math.min(area_1, area_2), area_3);
    }

    private static int calculateRibbonSurface(String[] dimensions)
    {
        int length = Integer.parseInt(dimensions[0]);
        int width  = Integer.parseInt(dimensions[1]);
        int height = Integer.parseInt(dimensions[2]);

        int volume = length * width * height;

        if      (length >= width && length >= height)    return 2 * (width + height) + volume;
        else if (height >= width && height >= length)    return 2 * (width + length) + volume;
        else                                             return 2 * (length + height) + volume;
        //if (width >= length && width  >= height)    

    }


}
