//Реализация метода перебора всех ключей для взлома
package core;

import service.FileService;

import java.util.ArrayList;
import java.util.List;

public class CaesarCoder {
    public static int key;

    //    Найти ключ
    public static void findKey() {
        StringBuilder keyStr = new StringBuilder();
        for (char i : FileService.arr) {
            if (Character.isDigit(i)) {
                keyStr.append(i);
            }
        }
        if (keyStr.length() > 0) {
            key = Integer.parseInt(keyStr.toString());
            System.out.println("Ключ из файла: " + key);
        } else {
            System.out.println("Ключ не найден!");
        }
    }
}

