package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.application.Menu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Actions {


    /**
     * @param src
     * @param dest метод расшифровывает брутфорсом
     */
    public static void decryptBrutForce(String src, String dest) {
        int key;
        if ((key = Actions2.rollToCheck(src)) == -1) {
            System.out.println("Брут форс не сработал");
            return;
        }
        Actions2.rollWithKey(src, dest, key);
    }

    /**
     * @param src
     * @param dest метод рсшифровки с ключом
     */
    public static void decryptWithKey(String src, String dest) {
        int key = Menu.inputKey();
        Actions2.rollWithKey(src, dest, (key * -1));
    }

    /**
     * @param srcOrig
     * @param src
     * @param dest    статистическая расшифровка
     */
    public static void decryptStatic(String srcOrig, String src, String dest) {
        HashMap<Character, Character> charsToChange = Actions2.charsToChange(srcOrig, src);
        System.out.println(charsToChange);
        try (FileReader input = new FileReader(src)) {
            char[] buff = new char[5000];
            while (input.ready()) {
                int buffSize = input.read(buff);
                try (FileWriter output = new FileWriter(dest, true)) {
                    for (int i = 0; i < buffSize; i++) {
                        output.write(charsToChange.get(buff[i]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
