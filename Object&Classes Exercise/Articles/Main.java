package SoftUni.Articles;

import java.util.Scanner;





public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split(",");

        String title = tokens[0];
        String content = tokens[1];
        String author = tokens[2];
        Article article = new Article(title,content,author);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
             tokens = sc.nextLine().split(":");
            switch (tokens[0]) {
                case "Edit":
                    article.setContent(tokens[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(tokens[1]);
                    break;
                case "Rename":
                    article.setTitle(tokens[1]);
                    break;
            }
        }

        System.out.println(article.toString());

    }
}
