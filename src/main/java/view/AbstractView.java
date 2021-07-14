package view;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class AbstractView {

    private final Scanner scanner;
    private final PrintStream output;
    private boolean interrupt;


    final String CREATE = "new";
    final String EDIT_BY_ID = "edit";
    final String GET_BY_ID = "get";
    final String GET_ALL = "get_all";
    final String DELETE = "delete";
    final String HELP_ME = "help_me";
    final String BACK_TO_BEGINNING = "back";
    final String EXIT = "exit";
    final String REPOSITORY_NAME;

    AbstractView(Scanner input, PrintStream output, String repositoryName) {
        this.scanner = input;
        this.output = output;
        this.REPOSITORY_NAME = repositoryName;
    }

    public void start() {

        output.print(REPOSITORY_NAME + ". \nНапишите: " + HELP_ME + "  - для получения помощи(справки) \n          " +
                EXIT + "  - для выхода из программы \n");

        while (!interrupt) {
            String cmd = scanner.nextLine();

            String[] command = cmd.split(" ");

            switch (command[0]) {
                case HELP_ME:
                    helpMe();
                    break;

                case CREATE:
                    createNewRecord(command);
                    break;

                case EDIT_BY_ID:
                    editRecord(command);
                    break;

                case DELETE:
                    deleteRecord(command);
                    break;

                case GET_BY_ID:
                    getById(command);
                    break;

                case GET_ALL:
                    allRecord(command);
                    break;

                case BACK_TO_BEGINNING:
                    backToBeginning();
                    break;

                case EXIT:
                    exit();
                    break;

                default:
                    System.out.println("Вы ввели неизвестный запрос! Напишите " + HELP_ME +
                            " для получения помощи(справки)");
                    break;
            }
        }
    }


    abstract void createNewRecord(String[] command);

    abstract void editRecord(String[] command);

    abstract void deleteRecord(String[] command);

    abstract void getById(String[] command);

    abstract void allRecord(String[] command);

    abstract void helpMe();

    abstract void backToBeginning();

    void exit() {
        interrupt = true;
    }

}
