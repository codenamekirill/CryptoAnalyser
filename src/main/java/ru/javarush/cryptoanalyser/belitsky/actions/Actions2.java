package ru.javarush.cryptoanalyser.belitsky.actions;

import ru.javarush.cryptoanalyser.belitsky.alphabet.Alphabet;
import ru.javarush.cryptoanalyser.belitsky.myclasses.CharInt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Actions2 {

    /**
     * @param src
     * @param dest
     * @param key
     * Метод крутит алфавит с ключом сделать приватным реализация зашифровки
     */
    public static void rollWithKey(String src, String dest, int key) {
        try (FileReader input = new FileReader(src)) {
            char[] buff = new char[5000];
            while (input.ready()) {
                int buffSize = input.read(buff);
                char[] buffToWrite = new char[buffSize];
                for (int i = 0, j = 0; i < buffSize; i++) {
                    char symbol = Character.toLowerCase(buff[i]);
                    if (Alphabet.alphabetContainsCheck(symbol))
                        buffToWrite[j++] = roll(Alphabet.indexOf(symbol), key);
                }
                finalTextWrite(dest, buffToWrite);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static char roll(int index, int key) {
        if (index + key < 0) index += Alphabet.getSize();
        return Alphabet.get((index + key) % Alphabet.getSize());
    }


    public static void finalTextWrite( String dest, char [] buff) {
            try (FileWriter output = new FileWriter(dest, true)) {
                    output.write(buff);
                } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int rollToCheck(String src) {
        try (FileReader input = new FileReader(src)) {
            long start = System.currentTimeMillis();
            char[] buff = new char[3000];
            int charSize = input.read(buff);
            for (int i = Alphabet.getSize() - 1; i > 0; i--) {
                boolean flag = true;
                for (int j = 0; j < charSize - 2; j++) {
                    if(i==29) System.out.println(j);
                    char symbol1 = roll(Alphabet.indexOf(buff[j]), i);
                    char symbol2 = roll(Alphabet.indexOf(buff[j + 1]), i);
                    char symbol3 = roll(Alphabet.indexOf(buff[j + 2]), i);
                    if (!Actions3.pairCheck(symbol1, symbol2)) {
                        flag = false;
                        break;
                    } else if (!Actions3.trioCheck(symbol1, symbol2, symbol3)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(System.currentTimeMillis() - start);
                    return i;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return -1;
    }

    public static HashMap<Character, Character> charsToChange(String srcOrig, String src) {

        try (FileReader inputOrig = new FileReader(srcOrig);
             FileReader input = new FileReader(src)) {
            ArrayList<CharInt> textOrig = Actions3.symbolsContainAnalyze(inputOrig);
            ArrayList<CharInt> text = Actions3.symbolsContainAnalyze(input);
            textOrig.sort(CharInt::compareTo);
            text.sort(CharInt::compareTo);
            HashMap<Character, Character> symbolsToChange = new HashMap<>();
            for (int i = 0; i < Math.min(textOrig.size(), text.size()); i++) {
                symbolsToChange.put(text.get(i).getSymbol(), textOrig.get(i).getSymbol());
            }
            return symbolsToChange;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
