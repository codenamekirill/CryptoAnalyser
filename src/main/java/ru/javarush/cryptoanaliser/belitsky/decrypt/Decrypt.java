package ru.javarush.cryptoanaliser.belitsky.decrypt;

import ru.javarush.cryptoanaliser.belitsky.actions.CharacterToChange;
import ru.javarush.cryptoanaliser.belitsky.actions.FinalTextWrite;
import ru.javarush.cryptoanaliser.belitsky.actions.RollToCheck;
import ru.javarush.cryptoanaliser.belitsky.actions.TextStatAnalyze;
import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;
import ru.javarush.cryptoanaliser.belitsky.application.Menu;
import ru.javarush.cryptoanaliser.belitsky.encrypt.RollWithKey;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    public static void decryptStatic(String srcOrig, String src, String dest) {
        HashMap<Character, Character> charsToChange = CharacterToChange.charsToChange(srcOrig, src);
        System.out.println(charsToChange);
        try (FileReader input = new FileReader(src)) {
            char [] buff = new char [5000];
            while (input.ready()) {
                int buffSize = input.read(buff);
                try (FileWriter output = new FileWriter(dest,true)) {
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
