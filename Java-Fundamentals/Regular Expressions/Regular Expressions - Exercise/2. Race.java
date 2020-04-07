package SoftUni.RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(",\\s+");
        ArrayList<String> racers = new ArrayList<>(Arrays.asList(data));
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        Pattern namePattern = Pattern.compile("[A-Za-z]");
        Pattern kmPattern = Pattern.compile("[0-9]");

        String input = scanner.nextLine();
        while (!"end of race".equals(input)) {
            Matcher matcher = namePattern.matcher(input);
            StringBuilder name = new StringBuilder();

            while (matcher.find()) {
                name.append(matcher.group());
            }
            matcher = kmPattern.matcher(input);


            if (racers.contains(name.toString())) {
                int km = 0;
                while (matcher.find()) {
                    km += Integer.parseInt(matcher.group());
                }
                result.putIfAbsent(name.toString(), 0);
                int oldKm = result.get(name.toString());

                result.put(name.toString(), oldKm + km);

            }


            input = scanner.nextLine();
        }



        int[] place = {1};
        result.entrySet()
                .stream()
                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
                .limit(3)
                .forEach(r->{
                    switch (place[0]){
                        case 1:
                            System.out.printf("1st place: %s%n",r.getKey());
                            break;
                        case 2:
                            System.out.printf("2nd place: %s%n",r.getKey());
                            break;
                        case 3:
                            System.out.printf("3rd place: %s%n",r.getKey());
                            break;
                    }
                    place[0]++;
                });


    }
}
