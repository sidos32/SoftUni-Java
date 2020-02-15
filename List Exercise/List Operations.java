import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> numbers = readStringList(scan);
 
        String input = scan.nextLine();
 
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
 
            switch (command) {
                case "Add":
                    String elementToAdd = tokens[1];
                    numbers.add(elementToAdd);
                    break;
                case "Insert": {
                    String number = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (isValidIndex(index, numbers)) {
                        numbers.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                }
                break;
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);
                    if (isValidIndex(index, numbers)) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                }
                break;
                case "Shift":
                    int rotCnt = Integer.parseInt(tokens[2]);
                    if ("left".equals(tokens[1])) {
                        for (int i = 0; i < rotCnt; i++) {
                            String temp = numbers.get(0);
                            for (int j = 0; j < numbers.size() - 1; j++) {
                                String nextElement = numbers.get(j + 1);
                                numbers.set(j, nextElement);
                            }
                            numbers.set(numbers.size() - 1, temp);
                        }
                    } else {
                        for (int i = 0; i < rotCnt; i++) {
                            String temp = numbers.get(numbers.size() - 1);
                            for (int j = numbers.size() - 1; j > 0; j--) {
                                String nextNumber = numbers.get(j - 1);
                                numbers.set(j, nextNumber);
                            }
                            numbers.set(0, temp);
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(" ", numbers));
    }
 
    public static ArrayList<String> readStringList(Scanner scanner) {
        ArrayList<String> output = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String element : input) {
            output.add(element);
        }
        return output;
    }
 
    public static boolean isValidIndex(int index, ArrayList<String> collection) {
        if (index >= 0 && index < collection.size()) {
            return true;
        } else {
            return false;
        }
    }
}
