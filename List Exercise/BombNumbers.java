package SoftUni;

        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class Main {


    public static void main (String[]args){


        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = readIntList(scan);
        String[] tokens = scan.nextLine().split("\\s+");
        int number = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);

        while (numbers.contains(number)) {
            int bombIndex = numbers.indexOf(number);

            int leftBound = Math.max(bombIndex - power, 0);
            int rightBound = Math.min(bombIndex + power, numbers.size() - 1);

            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (Integer integer : numbers) {
            sum += integer;
        }
        System.out.println(sum);
    }

    private static boolean isValidIndex ( int index, List<Integer > numbers){
        return index >= 0 && index <= numbers.size();
    }

    private static List<Integer> readIntList (Scanner scan){
        return Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
