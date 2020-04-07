package SoftUni.TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String text1 = input[0];
        String text2 = input[1];

        int sum = 0;
        int max = Math.max(text1.length(), text2.length());
        int min = Math.min(text1.length(), text2.length());


        for (int i = 0; i < max; i++) {
            if(i < min){
                sum +=  text1.charAt(i) * text2.charAt(i);

            }else if(text1.length() == max) {
                sum += text1.charAt(i);

            }else {
                sum += text2.charAt(i);
            }
        }

        System.out.println(sum);

    }
}
