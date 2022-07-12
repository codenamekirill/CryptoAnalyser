package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;

import java.io.FileReader;
import java.io.IOException;

public class RollToCheck {//для того чтобы проверить первые 150 символов на расшифровку а не весь файл

    public static int rollToCheck(String src) {
        try (FileReader input = new FileReader(src)) {

            char[] buff = new char[150];
            int charSize = input.read(buff);

            for (int i = Alphabet.getSize() - 1; i > 0; i--) {
                boolean flag = true;
                for (int j = 0; j < charSize - 2; j++) {
                    char symbol1 = Roll.roll(Alphabet.indexOf(buff[j]), i);
                    char symbol2 = Roll.roll(Alphabet.indexOf(buff[j + 1]), i);
                    char symbol3 = Roll.roll(Alphabet.indexOf(buff[j + 2]), i);
                    if (!SymbolsCheck.pairCheck(symbol1, symbol2)) {
                        flag = false;
                        break;
                    } else if (!SymbolsCheck.trioCheck(symbol1, symbol2, symbol3)) {
                        flag = false;
                        break;
                    }

                }
                if (flag) return i;
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }

        return -1;
    }


}
