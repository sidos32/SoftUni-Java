package SoftUni.Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int inputSize = input.length();
        Map<Character,Integer> mapOfStrings = new LinkedHashMap<>();


        for (int i = 0; i < inputSize; i++) {


            char ch = input.charAt(i);
            if(ch != 32){

                if(!mapOfStrings.containsKey(ch)){
                    mapOfStrings.put(ch,0); //Maybe 1 not 0
                }
                mapOfStrings.put(ch,mapOfStrings.get(ch)+1);
            }

        }


        for (var entry : mapOfStrings.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }


    }

}
