package SoftUni.Maps;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String,String> parkingList = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens  = sc.nextLine().split("\\s+");
            String command = tokens[0];
            String name = tokens[1];


            if(command.equals("register")){
                String licensePlateNumber = tokens[2];
                if(parkingList.containsKey(name)){
                    System.out.printf("ERROR: already registered with plate number %s\n",parkingList.get(name));
                }else{
                    parkingList.put(name,licensePlateNumber);
                    System.out.printf("%s registered %s successfully\n",name,licensePlateNumber);
                }
            }else{
                if(parkingList.containsKey(name)){
                    System.out.printf("%s unregistered successfully\n",name);
                    parkingList.remove(name);
                }else{
                    System.out.printf("ERROR: user %s not found\n",name);
                }
            }
        }

        parkingList.forEach((key, value) -> System.out.printf("%s => %s\n", key, value));


    }
}
