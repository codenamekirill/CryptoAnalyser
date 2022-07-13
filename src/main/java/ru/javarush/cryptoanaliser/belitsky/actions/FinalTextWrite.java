package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FinalTextWrite {//метод для записи файла с изменениями

    public static void finalTextWrite(String src, String dest, int key) {
        try (FileReader input = new FileReader(src)) {
            while (input.ready()) {
                char symbol = Character.toLowerCase((char) input.read());
                if (Alphabet.indexOf(symbol) == -1) continue;
                int index = Alphabet.indexOf(symbol);
                try (FileWriter output = new FileWriter(dest, true)) {
                    output.write(Roll.roll(index, key));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
