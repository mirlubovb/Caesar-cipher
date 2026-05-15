//Валидация входных данных, таких как существование файла, допустимость ключа.
package service;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidationService {
    public static void validationFile(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Файл отсутствует по указанному пути!");
        }

        if (!file.canRead()) {
            throw new FileNotFoundException("Нет прав на чтение файла");
        }
    }
}
