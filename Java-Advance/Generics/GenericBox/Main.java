package SoftUni.JavaAdvance.Generics.GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());


        for (int i = 0; i < n; i++) {
            Box<String> list = new Box<>(reader.readLine());

            System.out.println(list);
        }

    }
}
