package year_2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {


    private static int[] xmasLights = new int [1000 * 1000];   
    private static int[] xmasLights2 = new int [1000 * 1000];   

    public static void main(String[] args) {
        

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(".\\data\\year_2015\\day_6\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for (int i=0; i<xmasLights.length; ++i)     xmasLights[i]=0;
        for (int i=0; i<xmasLights2.length; ++i)     xmasLights2[i]=0;

        Pattern p = Pattern.compile("\\d+");
        int[] array = new int[4];

        for (String line : lines) {
            Matcher m = p.matcher(line);
            m.find();
            array[0] = Integer.parseInt(m.group());
            m.find();
            array[1] = Integer.parseInt(m.group());
            m.find();
            array[2] = Integer.parseInt(m.group());
            m.find();
            array[3] = Integer.parseInt(m.group());
    
            if (line.startsWith("turn on")){
                turnOn(xmasLights, array);
                turnOn2(xmasLights2, array);
            }
            else if (line.startsWith("turn off")) {
                turnOff(xmasLights, array);
                turnOff2(xmasLights2, array);
            }
            else if (line.startsWith("toggle")) {
                toggle(xmasLights, array);
                toggle2(xmasLights2, array);
            }   
        }

        int lightsOn = 0;
        for (int i=0; i<xmasLights.length; ++i) {
            if (xmasLights[i] == 1)     lightsOn++;
        }
        System.out.println(lightsOn);

        int brightness = 0;
        for (int i=0; i<xmasLights2.length; ++i) {
            brightness += xmasLights2[i];
        }
        System.out.println(brightness);
    }


    private static void turnOn (int [] array1, int [] array2)
    {
        for (int i = array2[0] ; i<=array2[2] ; ++i) {
            for (int j = array2[1] ; j<=array2[3] ; ++j)
                array1[i * 1000 + j] = 1;
        }  
    }

    private static void turnOn2 (int [] array1, int [] array2)
    {
        for (int i = array2[0] ; i<=array2[2] ; ++i) {
            for (int j = array2[1] ; j<=array2[3] ; ++j)
                array1[i * 1000 + j] += 1;
        }  
    }


    private static void turnOff (int [] array1, int [] array2)
    {
        for (int i = array2[0] ; i<=array2[2] ; ++i) {
            for (int j = array2[1] ; j<=array2[3] ; ++j)
                array1[i * 1000 + j] = 0;
        }
    }
    
    private static void turnOff2 (int [] array1, int [] array2)
    {
        for (int i = array2[0] ; i<=array2[2] ; ++i) {
            for (int j = array2[1] ; j<=array2[3] ; ++j)
                if (array1[i * 1000 + j] > 0)   array1[i * 1000 + j] -= 1 ;
        }
    }


    private static void toggle (int [] array1, int [] array2)
    {
        for (int i = array2[0] ; i<=array2[2] ; ++i) {
            for (int j = array2[1] ; j<=array2[3] ; ++j)
                array1[i * 1000 + j] = 1 - array1[i * 1000 + j];
        }
    }

    private static void toggle2 (int [] array1, int [] array2)
    {
        for (int i = array2[0] ; i<=array2[2] ; ++i) {
            for (int j = array2[1] ; j<=array2[3] ; ++j)
                array1[i * 1000 + j] += 2;
        }
    }

}

