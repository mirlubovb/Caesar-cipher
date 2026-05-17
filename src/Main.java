import core.Cipher;
import service.FileService;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static String path = "C:\\Users\\ук\\IdeaProjects\\cipher.txt";
    public static int key = 1;

    public static void main(String[] args) throws IOException {
        menu();
        input();
    }

    public static void menu() {
        System.out.println("Меню:\n1.Вывести текущий текст из файла\n2.Зашифровать текст\n3.Расшифровать текст");
        System.out.println("4.Изменить значение ключа\n5.Записать результат шифрования в файл");
    }

    public static void input() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи нужный номер действия:");

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            String textFromFile;
            String cipher;
            String decipher;
            textFromFile = FileService.readFromFile(path);

            if (number == 1) {
                System.out.println("Текст из файла: " + textFromFile);
            } else if (number == 2) {
                cipher = Cipher.cipherOnKey(key);
                System.out.println("Результат шифрования: " + cipher);
            } else if (number == 3) {
                cipher = Cipher.cipherOnKey(key);
                decipher = Cipher.decipher(cipher, key);
                System.out.println("Результат дешифрования: " + decipher);
            } else if (number == 4) {
                System.out.println("Введите новое значение ключа: ");
                int newKey = scanner.nextInt();
                key = newKey;
                System.out.println("Ключ изменен!");
            } else if (number == 5) {
                cipher = Cipher.cipherOnKey(key);
                FileService.writeToFile(path, cipher);
                System.out.println("Файл записан!");
            } else {
                System.out.println("Введите корректный номер без лишних символов");
            }
        }
    }
}