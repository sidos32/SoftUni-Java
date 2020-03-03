package SoftUni;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = Integer.parseInt(sc.nextLine());
        int dailyPlunder = Integer.parseInt(sc.nextLine());
        double expectedPlunder = Double.parseDouble(sc.nextLine());
        double totalPlunder = 0.0D;

        for(int i = 1; i <= days; ++i) {
            totalPlunder += (double)dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder += (double)dailyPlunder * 0.5D;
            }

            if (i % 5 == 0) {
                totalPlunder -= 0.30 * totalPlunder;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double result = totalPlunder / expectedPlunder * 100.0D;
            System.out.printf("Collected only %.2f%% of the plunder.", result);
        }

    }
}
