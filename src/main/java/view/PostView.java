package view;

import controller.PostController;
import model.Post;

import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PostView extends AbstractView {

    private static AbstractView abstractView;
    private final PostController postController;

    public PostView() {
        super(new Scanner(System.in), new PrintStream(System.out), "База данных записей(постов)");
        postController = new PostController();
    }


    @Override
    void createNewRecord(String[] command) {

        int content = 1;
        int writerId = 2;


        if (command.length > 2) {

            try {

                Post post = postController.create(new Post(command[content], Long.valueOf(command[writerId])));
                System.out.println(post.toString() + "\n");
                System.out.println("... Создание записи ...");

            } catch (NumberFormatException e) {
                System.out.println("Введена не правильная команда " + EDIT_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("Такой записи нет");
            }

        } else {
            System.out.println("Нет необходимых данных для создания " + CREATE);
        }
    }


    @Override
    void editRecord(String[] command) {

        int id = 1;
        int content = 2;
        int writerId = 3;

        if (command.length > 3) {
            System.out.println("... Изменение записи ...");
            try {

                Post post =  postController.update(new Post(Long.valueOf(command[id]), command[content],
                        Long.valueOf(command[writerId])));
                System.out.println(post.toString() + "\n");
                System.out.println("... Изменения внесены ... ");

            } catch (NumberFormatException e) {
                System.out.println("Введена не правильная команда " + EDIT_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("Такой записи нет");
            }
        } else {
            System.out.println("Нет необходимых данных для выполнения " + EDIT_BY_ID);
        }
    }


    @Override
    void getById(String[] command) {

        if (command.length > 1) {
            System.out.println("... Получаем записи(посты) ... ");

            try {

                Post post = postController.getById(Long.valueOf(command[1]));
                System.out.println(post.toString() + "\n");

            } catch (NumberFormatException e) {
                System.out.println("Неверная команда " + GET_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("Записи с таким ID нет");

            }

        } else {
            System.out.println("Нет необходимых данных для выполнения " + GET_BY_ID);

        }
    }

    @Override
    void allRecord() {

        System.out.println("... Получение всех записей ...");
        List<Post> postList = postController.getAll();

        if (postList.size() > 0) {
            postList.forEach((r) -> System.out.println(r.toString()));

        } else {
            System.out.println("Список пуст");
        }

    }


    @Override
    void deleteRecord(String[] command) {

        if (command.length > 1) {
            System.out.println("... Удаление записи  ...");

            try {

                postController.deleteById(Long.valueOf(command[1]));
                System.out.println("... Запись удален ...");

            } catch (NumberFormatException e) {
                System.out.println("Неправильная команда  " + DELETE);
            } catch (NoSuchElementException e) {
                System.out.println("Такой записи нет");
            }
        } else {
            System.out.println("Нет необходимых данных для выполнения  " + DELETE);
        }
    }

    @Override
    void helpMe() {

        System.out.println("Записи будут выводиться в виде:\n    ID | CREATED | UPDATED | CONTENT \n" +
                "Список команд для действий \n" +
                CREATE + " CONTENT WRITER_ID - добавить новую запись \n" +
                DELETE + " ID - удалить запись по ID \n" +
                GET_BY_ID + " ID - получить запись по ID \n" +
                GET_ALL + " - получить все записи \n" +
                EDIT_BY_ID + " ID CONTENT WRITER_ID  - изменить запись по ID \n" +
                BACK_TO_BEGINNING + " - вернуться в начало программы\n" +
                EXIT + " - выход из программы");
    }

    @Override
    void exit() {
        System.out.println("Выход из программы");
        super.exit();
    }


    @Override
    void backToBeginning() {
        AbstractView abstractView = RunnerView.getView();
        abstractView.start();
    }


    static AbstractView getInstance() {

        if (abstractView == null) {
            abstractView = new PostView();
        }
        return abstractView;
    }
}
