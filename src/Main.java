import core.CaesarCoder;
import core.Cipher;
import service.FileService;

import java.io.*;
import java.util.Scanner;

import static core.CaesarCoder.key;
import static core.Cipher.*;

public class Main {
    public static String path = "C:\\Users\\ук\\IdeaProjects\\cipher.tx";

    public static void main(String[] args) throws IOException {
        System.out.println("Текст из файла: ");
        FileService.readFromFile(path);
        System.out.println();
        CaesarCoder.findKey();
        String result = Cipher.cipherOnKey();
        System.out.println("Результат шифрования: " + result);
        FileService.writeToFile(path, result);
        //FileService.clearArr();
        String result1 = Cipher.decipher(result);
        System.out.println("Результат дешифрования: " + result1);
    }
}