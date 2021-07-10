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

        if (command.length > 2) {
            Region region = regionController.create(new Region(command[regionName], Long.valueOf(command[writerId])));
            System.out.println(region.toString() + "\n");
            System.out.println("... Страна добавлена ...");

        } else {
            System.out.println("Нет необходимых данных для добавления " + CREATE);
        }
    }


    @Override
    void editRecord(String[] command) {

        int id = 1;
        int regionName = 2;
        int writerId = 3;

        if (command.length > 3) {
            System.out.println("... Изменение записи ... \n");
            try {
                Region region = regionController.update(new Region(Long.valueOf(command[id]), command[regionName],
                        Long.valueOf(command[writerId])));
                System.out.println(region.toString() + "\n");
                System.out.println("... Страна изменена ...");

            } catch (NumberFormatException e) {
                System.out.println("Введена не правильная команда " + EDIT_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("В списке нет такой страны ");

            }
        } else {
            System.out.println("Нет необходимых данных для выполнения " + EDIT_BY_ID);
        }

    }


    @Override
    void getById(String[] command) {

        if (command.length > 1) {
            System.out.println("... Получение записи ...\n");

            try {

                Region region = regionController.getById(Long.valueOf(command[1]));
                System.out.println(region.toString() + "\n");

            } catch (NumberFormatException e) {
                System.out.println("Неверная команда " + GET_BY_ID);

            } catch (NoSuchElementException e) {
                System.out.println("Страны с таким ID нет");

            }
        } else {
            System.out.println("Нет необходимых данных для выполнения " + GET_BY_ID);
        }

    }


    @Override
    void allRecord() {

        System.out.println("... Получение всех записей ... \n");

        List<Region> regionList = regionController.getAll();

        if (regionList.size() > 0) {
            regionList.forEach((r) -> System.out.println((r.toString())));

        } else{
            System.out.println("Список стран пуст");
        }

    }


    @Override
    void deleteRecord(String[] command) {

        if (command.length > 1) {
            System.out.println("... Удаление страны из списка ... \n");

            try {

                regionController.deleteById(Long.valueOf(command[1]));
                System.out.println("... Страна удалена ... \n");

            } catch (NumberFormatException e) {
                System.out.println("Неправильная команда " + DELETE);

            } catch (NoSuchElementException e) {
                System.out.println("В списке нет такой страны ");
            }
        } else {
            System.out.println("Нет необходимых данных для выполнения " + DELETE);
        }
    }


    @Override
    void helpMe() {

        System.out.println("Записи будут  выводиться в виде: \n     ID | NAME_REGION \n" +
                "Список команд для действий \n" +
                CREATE + " NAME_REGION WRITER_ID- добавить новую страну в список\n" +
                EDIT_BY_ID + " ID NAME_REGION WRITER_ID - изменение существующей страны \n" +
                GET_BY_ID + " ID - получить название страны по ID \n" +
                GET_ALL + " - получение всех стран из списка \n" +
                DELETE + " ID - удаление страны \n" +
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
