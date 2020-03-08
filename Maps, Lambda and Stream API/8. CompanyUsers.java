import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> companies = new TreeMap<>();


        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split(" -> ");
            String companyName = tokens[0];
            String user = tokens[1];

            companies.putIfAbsent(companyName, new ArrayList<>());
            if (!companies.get(companyName).contains(user)) {

                companies.get(companyName).add(user);
            }

            command = scanner.nextLine();
        }

        companies.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());
                    entry.getValue()
                            .stream()
                            .forEach(e -> System.out.printf("-- %s%n", e));
                });
    }
}
