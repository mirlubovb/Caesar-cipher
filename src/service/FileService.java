//Работа с файлами (чтение и запись файлов)
package service;

import com.sun.tools.javac.Main;
import core.CaesarCoder;
import core.Cipher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    public static List<Character> arr = new ArrayList<>();

//  Чтение файла и вывод текста
    public static void readFromFile(String pathToFile) throws IOException {
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
                System.out.print((char)i);
            }
        }
    }

//    Запись текста в файл
    public static void writeToFile(String pathToFile, String result) throws IOException {
        File file = new File(pathToFile);
        try (FileOutputStream writes = new FileOutputStream(file)) {
            byte[] bytes = result.getBytes("UTF-8");
            writes.write(bytes);
            writes.write(CaesarCoder.key);
            System.out.println("Данные успешно записаны!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
