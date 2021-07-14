package view;

import controller.WriterController;
import model.Writer;

import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriterView extends AbstractView {

    private static AbstractView abstractView;
    private final WriterController writerController;


    public WriterView() {
        super(new Scanner(System.in), new PrintStream(System.out), "Список писателей ");
        writerController = new WriterController();
    }


    @Override
    void createNewRecord(String[] command) {

        int firstName = 1;
        int lastName = 2;

        if (command.length == 3) {

            Writer writer = writerController.create(command[firstName], command[lastName]);
            try {
                System.out.println(" ID |  Имя  |  Фамилия  |   Страна  |   Записи   |\n");
                System.out.println(writer.toString() + "\n");
                System.out.println("Новый писатель создан!");

            } catch (NumberFormatException e) {
                System.out.println("Неверная команда создания " + CREATE);
            }
        } else if (command.length > 3) {

            System.out.println("Вы ввели больше данных чем нужно");

        } else {
            System.out.println("Нет необходимых данных для выполнения " + CREATE);
        }

    }


    @Override
    void editRecord(String[] command) {

        int id = 1;
        int firstName = 2;
        int lastName = 3;

        if (command.length == 4) {

            System.out.println("... Изменение записи писателя ...");

            try {
                Writer writer = writerController.update(Long.valueOf(command[id]), command[firstName],
                        command[lastName]);
                System.out.println(" ID |  Имя  |  Фамилия  |   Страна  |   Записи   |\n");
                System.out.println(writer.toString() + "\n");
                System.out.println("... Изменения внесены ... ");

            } catch (NumberFormatException e) {
                System.out.println("Введена не правильная команда " + EDIT_BY_ID);
            } catch (NoSuchElementException e) {
                System.out.println("Такой записи нет");
            }
        } else if (command.length > 4){

            System.out.println("Вы ввели больше данных чем нужно");

        } else {
            System.out.println("Нет необходимых данных для выполнения " + EDIT_BY_ID);
        }

    }


    @Override
    void getById(String[] command) {

        if (command.length == 2) {
            System.out.println("... Вывод данных про писателя ...");

            try {
                Writer writer = writerController.getById(Long.valueOf(command[1]));
                System.out.println(" ID |  Имя  |  Фамилия  |   Страна  |   Записи   |\n");
                System.out.println(writer.toString() + "\n");

            } catch (NumberFormatException e) {
                System.out.println("Неверная команда " + GET_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("Писателя с таким ID нет ");
            }

        } else if (command.length > 2) {

            System.out.println("Вы ввели больше данных чем нужно");

        } else {
            System.out.println("Нет необходимых данных для выполнения " + GET_BY_ID);
        }
    }


    @Override
    void allRecord(String[] command) {

        if (command.length == 1) {
            System.out.println("... Получение всех данных ...");

            List<Writer> writerList = writerController.getAll();

            if (writerList.size() > 0) {
                System.out.println(" ID |  Имя  |  Фамилия  |   Страна  |   Записи   |\n");

                writerList.forEach((w) -> System.out.println((w.toString())));

            } else{
                System.out.println("Список писателей пуст");
            }
        } else {
            System.out.println("Вы ввели больше данных чем нужно");
        }

    }


    @Override
    void deleteRecord(String[] command) {

        if (command.length == 2) {
            System.out.println("... Удаление данных писателя ...");

            try {
                writerController.deleteById(Long.valueOf(command[1]));

            } catch (NumberFormatException e) {
                System.out.println("Неправильная команда " + DELETE);

            } catch (NoSuchElementException e) {
                System.out.println("Такого писателя нет(неправильный ID)");
            }

        } else if (command.length > 2) {

            System.out.println("Вы ввели больше данных чем нужно");

        } else {
            System.out.println("Не написано комманда " + DELETE);
        }

    }


    @Override
    void helpMe() {

        System.out.println("          Список команд для действий: \n\n"  +
                CREATE + " 'Имя'  'Фамилия'  - создание нового пользователя \n" +
                GET_BY_ID + " 'ID' - получение одного из писателей по ID \n" +
                GET_ALL + " - получение данных про всех писателей \n" +
                EDIT_BY_ID + "  'ID' 'Имя'  'Фамилия' - изменить данные писателя по ID \n" +
                DELETE + " 'ID' - удаление писателя по ID  \n" +
                BACK_TO_BEGINNING + " - вернуться в начало программы\n" +
                EXIT + " - выход из программы");
    }


    @Override
    void backToBeginning() {
        AbstractView abstractView = RunnerView.getView();
        abstractView.start();
    }


    static AbstractView getInstance() {
        if (abstractView == null) {
            abstractView = new WriterView();
        }
        return abstractView;
    }
}
