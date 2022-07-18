package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;
import ru.javarush.cryptoanaliser.belitsky.myclasses.CharInt;
import ru.javarush.cryptoanaliser.belitsky.myclasses.StringInt;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextStatAnalyze {

    public static ArrayList<CharInt> symbolsContainAnalyze(FileReader input) throws IOException {
        char[] buff = new char[5000];
        ArrayList<CharInt>symbolList=new ArrayList<>();
        while (input.ready()) {
            int buffSize = input.read(buff);
            for (int i = 0; i < buffSize; i++) {
                char symbol = Character.toLowerCase(buff[i]);
                if (!Alphabet.alphabetContainsCheck(symbol)) continue;
                CharInt charInt = new CharInt(symbol,1);
                if (symbolList.contains(charInt)) {
                    int index = symbolList.indexOf(charInt);
                    charInt.setSymbolQuantity(symbolList.get(index).getSymbolQuantity()+1);
                    symbolList.set(index,charInt);
                } else symbolList.add(charInt);
            }
        }
        symbolList.sort(CharInt::compareTo);
        return symbolList;
    }
}
