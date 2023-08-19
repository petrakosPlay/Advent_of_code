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
    private static List<String> instructions;
    private static Map <String, Integer> wires;

    public static void main(String[] args)
    {

        wires = new HashMap<>(50);

        try {
            instructions = Files.readAllLines(Paths.get(".\\data\\year_2015\\day_7\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Integer wireSignal = calculateWireSignal("a");
        System.out.println("The signal on wire \"a\" is: " +  (wireSignal == -1 ? "Not found" : Integer.toString(wireSignal)) );
        
    }

    private static Integer calculateWireSignal (String targetWire)
    { 
        try {
            return Integer.parseInt(targetWire);
        } catch (NumberFormatException e) {
            if (wires.containsKey(targetWire) == true)
                return wires.get(targetWire);
        }
  
        int i; String instruction = null;
        for (i=0; i<instructions.size(); ++i) {
            if (instructions.get(i).substring(instructions.get(i).indexOf('>') + 2).equals(targetWire) == true) {
                instruction = instructions.get(i);
                break;
            }   
        }
        if (instruction == null)  return -1;


        String[] operands = instruction.split(" ");

        if(operands[1].equals("->")) {
            wires.put(targetWire, calculateWireSignal(operands[0]));            
        }
        else if(operands[0].equals("NOT")) {
            wires.put(targetWire, ~calculateWireSignal(operands[1]));
        }
        else if (operands[1].equals("AND")) {
            wires.put(targetWire, calculateWireSignal(operands[0]) & calculateWireSignal(operands[2]));
        }
        else if (operands[1].equals("OR")) {
            wires.put(targetWire, calculateWireSignal(operands[0]) | calculateWireSignal(operands[2]));
        }
        else if (operands[1].equals("LSHIFT")) {
            wires.put(targetWire, calculateWireSignal(operands[0]) << calculateWireSignal(operands[2]));
        }
        else if (operands[1].equals("RSHIFT")) {
            wires.put(targetWire, calculateWireSignal(operands[0]) >> calculateWireSignal(operands[2]));
        }
        return wires.get(targetWire);
    }

}














/*     
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





//Stream <String> stream = lines.stream();
        //System.out.println(stream);
        //String target = lines.stream().filter( s -> s.substring(s.indexOf('>') + 2).equals("lx")).findFirst().get();
        //System.out.println(target);


        //String[] ops = new String[5];
        //int operand1, operand2;

        /*for (String instruction : instructions) {
            System.out.println(instruction);
            String outputWire = instruction.substring(instruction.indexOf('>') + 2);
            System.out.println(outputWire);
           // if (map.containsKey(outputWire) == false)
          //      calculateSignal(instruction, outputWire);
        }*/