package view;

import java.util.Scanner;

public class RunnerView {

    private final static Scanner scanner = new Scanner(System.in);

    public static final String WRITERS = "writers";
    public static final String POSTS = "posts";
    public static final String REGIONS = "regions";




    public static AbstractView getView () {

        System.out.println("Напишите имя папки куда хотите зайти \n" +
                "writers\n" +
                "posts\n" +
                "regions");


        String type = scanner.next();

        switch (type) {

            case WRITERS:
                return WriterView.getInstance();

            case POSTS:
                return PostView.getInstance();

            case REGIONS:
                return RegionView.getInstance();

            default:
                throw new RuntimeException("Недопустимый аргумент для типа экземпляра " + type);
        }
    }
}
