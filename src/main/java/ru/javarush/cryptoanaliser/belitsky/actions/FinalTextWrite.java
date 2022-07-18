package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FinalTextWrite {//метод для записи файла с изменениями

    public static void finalTextWrite(String src, String dest, int key) {
        try (FileReader input = new FileReader(src)) {
            char[] buff = new char[5000];
            while (input.ready()) {
                int buffSize = input.read(buff);

                try (FileWriter output = new FileWriter(dest, true)) {
                    for (int i = 0; i < buffSize; i++) {
                        char symbol = Character.toLowerCase(buff[i]);
                        if (Alphabet.indexOf(symbol) == -1) continue;
                        int index = Alphabet.indexOf(symbol);
                        output.write(Roll.roll(index, key));
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
