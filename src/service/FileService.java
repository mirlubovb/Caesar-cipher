//Работа с файлами (чтение и запись файлов)
package service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static List<Character> arr = new ArrayList<>();

//  Чтение файла и вывод текста
    public static String readFromFile(String pathToFile) throws IOException {
        StringBuilder result = new StringBuilder();
        try {
            ValidationService.validationFile(pathToFile);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
            throw new IOException("Невозможно прочитать файл");
        }
        File file = new File(pathToFile);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            int i;
            while ((i = reader.read()) != -1) {
                arr.add((char)i);
                result.append((char)i);
            }
        }

        return result.toString();
    }

//    Запись текста в файл
    public static void writeToFile(String pathToFile, String result) throws IOException {
        File file = new File(pathToFile);
        try (FileOutputStream writes = new FileOutputStream(file)) {
            byte[] bytes = result.getBytes("UTF-8");
            writes.write(bytes);
            System.out.println("Данные успешно записаны!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
