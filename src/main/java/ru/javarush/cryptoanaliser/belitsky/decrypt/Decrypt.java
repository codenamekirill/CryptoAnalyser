package ru.javarush.cryptoanaliser.belitsky.decrypt;

import ru.javarush.cryptoanaliser.belitsky.actions.FinalTextWrite;
import ru.javarush.cryptoanaliser.belitsky.actions.RollToCheck;
import ru.javarush.cryptoanaliser.belitsky.application.Menu;
import ru.javarush.cryptoanaliser.belitsky.encrypt.RollWithKey;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Decrypt {

    public static void decryptBrutForce(String src, String dest) {
        int key;
        if ((key = RollToCheck.rollToCheck(src)) == -1) {
            System.out.println("Брут форс не сработал");
            return;
        }
        FinalTextWrite.finalTextWrite(src, dest, key);
    }

    public static void decryptWithKey(String src, String dest) {
        int key = Menu.inputKey();
        RollWithKey.rollWithKey(src, dest, (key * -1));
    }

    public static void decryptStatic(String src, String dest) {
        try (FileReader input = new FileReader(src)) {
            char[] buff = new char[3000];
            HashMap<Character, Integer> symbolMap = new HashMap<>();
            for (int i = 0; i < buff.length; i++) {
                if (symbolMap.containsKey(buff[i])) {
                    Integer value = symbolMap.get(buff[i]);
                    value++;
                    symbolMap.put(buff[i], value);
                } else symbolMap.put(buff[i], 1);
            }
            int counter = 0;
            for (Character character : symbolMap.keySet()) {
                if (!(counter>=symbolMap.get(character)))counter= symbolMap.get(character);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
