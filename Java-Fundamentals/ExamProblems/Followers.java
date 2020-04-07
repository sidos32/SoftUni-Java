package SoftUni.Exams;

import java.util.*;

public class Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> usersLikes = new TreeMap<>();
        Map<String, Integer> usersCommends = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String userName = tokens[1];

            switch (command) {
                case "New follower":

                    if (!usersLikes.containsKey(userName)) {

                        usersLikes.put(userName, 0);
                        usersCommends.put(userName, 0);
                    }
                    break;
                case "Like":
                    int likes = Integer.parseInt(tokens[2]);

                    if (usersLikes.containsKey(userName)) {
                        int oldLikes = usersLikes.get(userName);
                        oldLikes += likes;
                        usersLikes.put(userName, oldLikes);

                    } else {
                        usersLikes.put(userName, likes);
                        usersCommends.put(userName, 0);
                    }

                    break;
                case "Comment":

                    if (usersLikes.containsKey(userName)) {
                        int oldCommends = usersCommends.get(userName);
                        usersCommends.put(userName, ++oldCommends);
                    } else {
                        usersLikes.put(userName, 0);
                        usersCommends.put(userName, 1);
                    }

                    break;
                case "Blocked":
                    if (usersLikes.containsKey(userName)) {
                        usersLikes.remove(userName);
                        usersCommends.remove(userName);
                    } else {
                        System.out.println(userName + " doesn't exist.");
                    }
                    break;
            }

            input = scanner.nextLine();
        }


        Map<String, Integer> total = new TreeMap<>();

        for (var it : usersLikes.entrySet()) {
            int count = it.getValue() + usersCommends.get(it.getKey());
            total.put(it.getKey(), count);
        }
        System.out.println(total.size() + " followers");
        total.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    }

                    return Integer.compare(e2.getValue(), e1.getValue());
                })
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue());

                });


    }

}
