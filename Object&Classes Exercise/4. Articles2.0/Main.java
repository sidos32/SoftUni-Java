package SoftUni.Articles;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Article> Articles = new ArrayList<>();

        int numOfArticles = Integer.parseInt(sc.nextLine());

        fillingArticles(sc, Articles, numOfArticles);

        String sortingBy = sc.nextLine();


        switch (sortingBy) {
            case "title":
                printingArticlesTitle(Articles);
                break;
            case "content":
                printingArticlesContent(Articles);
                break;
            case "author":
                printingArticlesAuthor(Articles);
                break;
        }


    }

    private static void fillingArticles(Scanner sc, ArrayList<Article> articles, int n) {
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(",");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];
            Article article = new Article(title, content, author);
            articles.add(article);
        }
    }

    private static void printingArticlesAuthor(ArrayList<Article> articles) {
        articles.stream()
                .sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                .forEach(a -> System.out.println(a.toString()));
    }

    private static void printingArticlesContent(ArrayList<Article> articles) {
        articles.stream()
                .sorted((a1, a2) -> a1.getContent().compareTo(a2.getContent()))
                .forEach(a -> System.out.println(a.toString()));
    }

    private static void printingArticlesTitle(ArrayList<Article> articles) {
        articles.stream()
                .sorted((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()))
                .forEach(a -> System.out.println(a.toString()));
    }
}
