package SoftUni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class CardsGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> player1 = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> player2 = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (player1.size() > 0 && player2.size() > 0) {


            int firstPlayerCard = player1.remove(0);
            int secondPlayerCard = player2.remove(0);

            if (firstPlayerCard > secondPlayerCard) {
                player1.add(firstPlayerCard);
                player1.add(secondPlayerCard);

            } else if (secondPlayerCard > firstPlayerCard) {
                player2.add(secondPlayerCard);
                player2.add(firstPlayerCard);
            }

        }

        printWinner(player1, player2);

    }

    private static void printWinner(List<Integer> player1, List<Integer> player2) {
        int player1Points = 0;
        int player2Points = 0;

        for (int it : player1) {
            player1Points += it;

        }
        for (int it : player2) {
            player2Points += it;
        }

        if (player1Points > player2Points) {
            System.out.println("First player wins! Sum: " + player1Points);
        } else if (player2Points > player1Points) {
            System.out.println("Second player wins! Sum: " + player2Points);
        }


    }
}
