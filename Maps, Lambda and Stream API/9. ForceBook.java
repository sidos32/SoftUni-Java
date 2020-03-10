package SoftUni.Maps;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<String>> sides = new TreeMap<>();
        String command = scanner.nextLine();


        while (!"Lumpawaroo".equals(command)) {
            String[] tokens;
            if (command.contains("->")) {
                tokens = command.split(" -> ");
                String person = tokens[0];
                String force = tokens[1];

                sides.putIfAbsent(force, new ArrayList<>());

                String tmpForce = force;

                tmpForce = changeForceSide(sides, tmpForce);

                if (sides.get(tmpForce).contains(person)) {
                    sides.get(force).add(person);
                    sides.get(tmpForce).remove(person);
                } else {
                    sides.get(force).add(person);
                }

                System.out.printf("%s joins the %s side!%n", person, force);


            } else {
                tokens = command.split(" \\| ");
                String force = tokens[0];
                String person = tokens[1];

                sides.putIfAbsent(force, new ArrayList<>());

                if (!sides.get(force).contains(person)) {
                    sides.get(force).add(person);
                }
            }

            command = scanner.nextLine();
        }


        sides
                .entrySet()
                .stream()
                .filter(p -> p.getValue().size() > 0)
                .sorted(Map.Entry.<String, ArrayList<String>>comparingByValue(Comparator.comparing(ArrayList::size))
                        .reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });
    }

    private static String changeForceSide(TreeMap<String, ArrayList<String>> sides, String tmpForce) {
        for (var entry : sides.entrySet()) {
            if (!entry.getKey().equals(tmpForce)) {
                tmpForce = entry.getKey();
                break;
            }
        }
        return tmpForce;
    }
}
