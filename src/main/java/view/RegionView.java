package view;

import controller.RegionController;
import model.Region;

import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RegionView extends AbstractView {

    private static AbstractView abstractView;
    private final RegionController regionController;

    RegionView() {
        super(new Scanner(System.in), new PrintStream(System.out), "Список регионов");
        regionController = new RegionController();
    }

    @Override
    void createNewRecord(String[] command) {

        int regionName = 1;
        int writerId = 2;

        if (command.length == 3) {
            Region region = regionController.create(command[regionName], Long.valueOf(command[writerId]));

            System.out.println("'ID' | 'Название региона'| 'ID писателя' | \n");
            System.out.println(region.toString() + "\n");
            System.out.println("... Страна добавлена ...");

        } else if (command.length > 3){

            System.out.println("Вы ввели больше данных чем нужно");

        } else {
            System.out.println("Нет необходимых данных для добавления " + CREATE);
        }
    }


    @Override
    void editRecord(String[] command) {

        int id = 1;
        int regionName = 2;
        int writerId = 3;

        if (command.length == 4) {
            System.out.println("... Изменение записи ... \n");
            try {
                Region region = regionController.update(Long.valueOf(command[id]), command[regionName],
                        Long.valueOf(command[writerId]));
                System.out.println("'ID' | 'Название региона'| 'ID писателя' | \n");
                System.out.println(region.toString() + "\n");
                System.out.println("... Страна изменена ...");

            } catch (NumberFormatException e) {
                System.out.println("Введена не правильная команда " + EDIT_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("В списке нет такой страны ");

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
            System.out.println("... Получение записи ...\n");

            try {

                Region region = regionController.getById(Long.valueOf(command[1]));
                System.out.println("'ID' | 'Название региона'| 'ID писателя' | \n");
                System.out.println(region.toString() + "\n");

            } catch (NumberFormatException e) {
                System.out.println("Неверная команда " + GET_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("Страны с таким ID нет");

            }
        } else if (command.length > 2){

            System.out.println("Вы ввели больше данных чем нужно");

        } else {
            System.out.println("Нет необходимых данных для выполнения " + GET_BY_ID);
        }

    }


    @Override
    void allRecord(String[] command) {

        if (command.length == 1) {
            System.out.println("... Получение всех записей ... \n");

            List<Region> regionList = regionController.getAll();

            if (regionList.size() > 0) {
                System.out.println("'ID' | 'Название региона'| 'ID писателя' \n");

                regionList.forEach((r) -> System.out.println((r.toString())));

            } else {
                System.out.println("Список стран пуст");
            }
        } else {
            System.out.println("Вы ввели больше данных чем нужно");
        }


    }


    @Override
    void deleteRecord(String[] command) {

        if (command.length == 2) {
            System.out.println("... Удаление страны из списка ... \n");

            try {

                regionController.deleteById(Long.valueOf(command[1]));

            } catch (NumberFormatException e) {
                System.out.println("Неправильная команда " + DELETE);

            } catch (NoSuchElementException e) {
                System.out.println("В списке нет такой страны ");
            }
        } else if (command.length > 2){

            System.out.println("Вы ввели больше данных чем нужно");

        } else {
            System.out.println("Нет необходимых данных для выполнения " + DELETE);
        }
    }


    @Override
    void helpMe() {

        System.out.println("          Список команд для действий: \n\n" +
                CREATE + " 'название региона' 'ID писателя' - добавить новую страну в список\n" +
                GET_BY_ID + " 'ID' - получить название страны по ID \n" +
                GET_ALL + " - получение всех стран из списка \n" +
                EDIT_BY_ID + " 'ID' 'название региона' 'ID писателя' - изменение существующей страны \n" +
                DELETE + " 'ID' - удаление страны по ID \n" +
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
            abstractView = new RegionView();
        }
        return abstractView;
    }
}
