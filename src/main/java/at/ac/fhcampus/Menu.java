package at.ac.fhcampus;

import java.util.Scanner;
import java.util.*;

public class Menu {
    private final AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "Your input was invalid. Please enter a letter from one of the given choices.";
    private static final String EXIT_MESSAGE = "Have a nice day!";
    private static final String NO_RESULTS_MESSAGE = "No article was found.";

    public void start() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        handleInput(scanner.nextLine().toLowerCase());
    }

    private void handleInput(String input) {
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            // case "c" -> ;
            // case "d" -> ;
            case "e" -> getProviderMostArticles(controller);
            case "f" -> getLongestAuthor(controller);
            case "g" -> getNYTArticles(controller);
            case "h" -> getShortHeadline(controller);
            case "i" -> sortArticles(controller);
            case "y" -> getArticleCount(controller);
            case "q" -> printExitMessage();
            default -> printInvalidInputMessage();
        }
        if(!input.equals("q")) start();
    }

    private void getArticleCount(AppController ctrl) {
        System.out.println("Number of articles: " + ctrl.getArticleCount());
    }

    private void getProviderMostArticles(AppController ctrl){

    }

    private void getLongestAuthor(AppController ctrl){

    }

    private void getNYTArticles(AppController ctrl){

    }

    private void getShortHeadline(AppController ctrl){

    }

    private void sortArticles(AppController ctrl){

    }

    /*

    // welche source hat meiste artikel
    List<Article> ArticleListNew;
    ArticleListNew = new List<Article>;
Stream<Article> streamFromList = ArticleListNew.stream()
        .map ()

// welche autor längster name
        .max (Comparator.comparingInt(Article.getAuthor()::getLength()))
// wie viele Artikel stammen von source "New York Times"
streamFromList.
// welche artikel haben eine Headline die weniger als 15 Zeichen hat
streamFromList.
// sortiert die Artikel nach der Länge ihrer Beschreibung aufsteigend; bei gleich alphabetisch
streamFromList.
     */

    private void getTopHeadlinesAustria(AppController ctrl) {
        if(ctrl.getTopHeadlinesAustria("Wien") == null) {
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

        List<Article> temp = ctrl.getTopHeadlinesAustria("Wien").getArticles();

        for (Article article : temp) {
            System.out.println(article);
        }
    }

    private void getAllNewsBitcoin(AppController ctrl) {
        if(ctrl.getAllNewsBitcoin("bitcoin") == null) {
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

        List<Article> temp = ctrl.getAllNewsBitcoin("bitcoin").getArticles();

        for (Article article : temp) {
            System.out.println(article);
        }
    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInvalidInputMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private static void printMenu() {
        System.out.println("############################");
        System.out.println("#    Welcome to NewsApp    #");
        System.out.println("############################");
        System.out.println("Please enter what you wanna do:");
        System.out.println("a: Get top headlines austria");
        System.out.println("b: get all news about bitcoin");
        System.out.println("c: Count articles");
        System.out.println("d: Count articles");
        System.out.println("e: Get the Provider with the most Articles");
        System.out.println("f: Get the Author with the longest name");
        System.out.println("g: Get the New York Times Articles");
        System.out.println("h: Get short headline Articles");
        System.out.println("i: Sort the articles shortest to longest");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }
}
