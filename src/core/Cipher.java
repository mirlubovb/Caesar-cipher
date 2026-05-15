//Класс, реализующий функциональность шифра Цезаря и дешифровки
package core;

import service.FileService;

import java.util.Locale;

public class Cipher {
    private static char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public Cipher(char[] ALPHABET) {
        this.ALPHABET = ALPHABET;
    }

    public static char[] getCipher() {
        return ALPHABET;
    }

//    Шифрование текста
    public static String cipherOnKey() {
        StringBuilder result = new StringBuilder();
        int lengthCipher = getCipher().length;
        for (int i = 0; i < FileService.arr.size(); i++) {
            char currentChar = FileService.arr.get(i);
            char lowerChar = Character.toLowerCase(currentChar);

            for (int j = 0; j < lengthCipher; j++)
                if (lowerChar == getCipher()[j]) {
                    int index = (j + CaesarCoder.key) % lengthCipher;
                    result.append(getCipher()[index]);
                }
        }
        return result.toString();
    }
//Расшифровка текста
    public static String decipher(String str) {
        StringBuilder result = new StringBuilder();
        int lengthCipher = getCipher().length;
        int lengthStr = str.length();
        boolean found;
        for (int i = 0; i < lengthStr; i++) {
            found = false;
            char currentChar = str.charAt(i);
            char lowerChar = Character.toLowerCase(currentChar);

            for (int j = 0; j < lengthCipher; j++) {
                if (lowerChar == getCipher()[j]) {
                    int index = (j - CaesarCoder.key + lengthCipher) % lengthCipher;
                    result.append(getCipher()[index]);
                    found = true;
                    break;
                }
            }

            if (!found ) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
