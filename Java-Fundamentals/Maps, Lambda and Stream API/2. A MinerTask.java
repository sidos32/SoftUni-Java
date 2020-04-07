package SoftUni.Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.next();

        Map<String, Integer> mined = new LinkedHashMap();


        while (!(command.equalsIgnoreCase("stop"))) {
            int resource = scanner.nextInt();


            if (!mined.containsKey(command)) {
                mined.put(command, 0);
            }
            mined.put(command, mined.get(command) + resource);


            command = scanner.next();

        }

        for (Map.Entry<String, Integer> entry : mined.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }


    }
}
