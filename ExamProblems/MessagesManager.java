package SoftUni.Exams;

import java.util.*;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<Integer>> users = new TreeMap<>();
        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!"Statistics".equals(input)) {

            String[] tokens = input.split("=");

            if ("Add".equals(tokens[0])) { //Add if doesn't exist and skipping if already exists
                String userName = tokens[1];
                if (!users.containsKey(userName)) {
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);

                    ArrayList<Integer> messages = new ArrayList<>();

                    messages.add(sent);  // At index 0 == sent messages
                    messages.add(received);// At index 1 == received messages
                    users.put(userName, messages);
                }

            } else if ("Message".equals(tokens[0])) { //Incrementing sent and received messages
                String userNameSent = tokens[1];
                String userNameReceived = tokens[2];

                if (users.containsKey(userNameSent) && users.containsKey(userNameReceived)) {
                    int oldSent = users.get(userNameSent).get(0); //Get old Sent messages
                    int oldReceived = users.get(userNameReceived).get(1);//Get old Received messages

                    users.get(userNameSent).add(0, ++oldSent);//Incrementing Sent messages at index 0 of ArrayList

                    if (isCapacityReached(users, userNameSent, capacity)) {
                        users.remove(userNameSent);  //Remove if capacity reached
                        System.out.println(userNameSent + " reached the capacity!");
                    }
                    users.get(userNameReceived).add(1, ++oldReceived);////Incrementing Received messages at index 1

                    if (isCapacityReached(users, userNameReceived, capacity)) {
                        users.remove(userNameReceived);  //Remove if capacity reached
                        System.out.println(userNameReceived + " reached the capacity!");
                    }
                }

            } else if ("Empty".equals(tokens[0])) {
                String userName = tokens[1];

                if (userName.equals("All")) {
                    users = new TreeMap<>();
                }
                users.remove(userName);
            }


            input = scanner.nextLine();
        }

        System.out.printf("Users count: %d%n", users.size());

        Map<String,Integer> total  = new TreeMap<>();

        for (var user : users.entrySet()) {
            String name = user.getKey();
            int messages = accumulateMessages(users,user.getKey());
            total.put(name,messages);
        }

        total.entrySet()
                .stream()
                .sorted((u1,u2) -> u2.getValue() - u1.getValue())
                .forEach(entry -> System.out.printf("%s - %d%n",entry.getKey(),entry.getValue()));

    }

    private static boolean isCapacityReached(Map<String, ArrayList<Integer>> users, String name, int capacity) {
        int sent = users.get(name).get(0); //Get Sent messages
        int received = users.get(name).get(1);//Get Received messages

        return sent + received >= capacity;
    }

    private static int accumulateMessages(Map<String, ArrayList<Integer>> users, String name) {
        int total = 0;
        for (var it:users.get(name)) {
            total += it;
        }
        return total;
    }


}