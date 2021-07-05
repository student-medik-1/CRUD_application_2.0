package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {

    private final static String pathToFile = "src/main/resources/";

    public static List<String> read (String fileName) {

        List<String> dataList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader( new FileInputStream(getPath(fileName)), StandardCharsets.UTF_8))) {

            String str;

            while ((str = bufferedReader.readLine()) != null) {
                dataList.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  dataList;
    }

    public static void write(String fileName, String data) {

        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(getPath(fileName), true))) {

            bufferedWriter.write(data);
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeList (String fileName, List<String> dataList) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(getPath(fileName), false))) {

            for (String str : dataList) {

                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static String getPath(String fileName) {

        Path absolutePath = Paths.get("").toAbsolutePath();
        String path = absolutePath + pathToFile + fileName;

        return path;
    }
}
