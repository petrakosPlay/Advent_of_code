package year_2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Day_7 
{
    

    public static void main(String[] args)
    {
    

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(".\\data\\year_2015\\day_7\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        //Stream <String> stream = lines.stream();
        //System.out.println(stream);
        String target = lines.stream().filter( s -> s.substring(s.indexOf('>') + 2).equals("lx")).findFirst().get();
        System.out.println(target);


        

/*
        Map <String, Integer> map = new HashMap<>(50);
        String[] ops = new String[5];
        int operand1, operand2;
        for (String line : lines) {
            System.out.println(line);
            ops = line.split(" ");
        
            if(ops[0].equals("NOT"))   map.put(ops[3], ~map.getOrDefault(ops[1],0));
            else if (ops[1] .equals("->"))
            {
                try {
                    operand1 = Integer.parseInt(ops[0]);
                } catch (NumberFormatException e) {
                    operand1 = map.getOrDefault(ops[0],0);   
                }
                map.put(ops[2], operand1);
            }
            else if (ops[1].equals("AND"))
            {
                try {
                    operand1 = Integer.parseInt(ops[0]);
                } catch (NumberFormatException e) {
                    operand1 = map.getOrDefault(ops[0],0);
                    
                }
                try {
                    operand2 = Integer.parseInt(ops[2]);
                } catch (NumberFormatException e) {
                    operand2 = map.getOrDefault(ops[2],0);
                }
                map.put(ops[4], operand1 & operand2);
            }
            else if (ops[1].equals("OR"))
            {
                try {
                    operand1 = Integer.parseInt(ops[0]);
                } catch (NumberFormatException e) {
                    operand1 = map.getOrDefault(ops[0],0);
                }
                try {
                    operand2 = Integer.parseInt(ops[2]);
                } catch (NumberFormatException e) {
                    operand2 = map.getOrDefault(ops[2],0);
                }
                map.put(ops[4], operand1 | operand2);
            }  
            else if (ops[1].equals("RSHIFT"))
            {
                try {
                    operand1 = Integer.parseInt(ops[0]);
                } catch (NumberFormatException e) {
                    operand1 = map.getOrDefault(ops[0],0);
                }
                try {
                    operand2 = Integer.parseInt(ops[2]);
                } catch (NumberFormatException e) {
                    operand2 = map.getOrDefault(ops[2],0);
                }
                map.put(ops[4], operand1 >> operand2);
            }  
            else if (ops[1].equals("LSHIFT"))
            {
                try {
                    operand1 = Integer.parseInt(ops[0]);
                } catch (NumberFormatException e) {
                    operand1 = map.getOrDefault(ops[0],0);
                }
                try {
                    operand2 = Integer.parseInt(ops[2]);
                } catch (NumberFormatException e) {
                    operand2 = map.getOrDefault(ops[2],0);
                }
                map.put(ops[4], operand1 << operand2);
            }  
        }
        System.out.println(map.get("a"));
    */
    }
}






