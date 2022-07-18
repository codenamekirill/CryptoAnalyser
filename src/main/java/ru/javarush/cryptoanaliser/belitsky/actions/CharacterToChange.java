package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.myclasses.CharInt;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharacterToChange {

    public static HashMap<Character, Character> charsToChange(String srcOrig, String src) {

        try (FileReader inputOrig = new FileReader(srcOrig);
             FileReader input = new FileReader(src)) {
            ArrayList<CharInt> textOrig = TextStatAnalyze.symbolsContainAnalyze(inputOrig);
            System.out.println(textOrig);
            System.out.println(textOrig.size());
            ArrayList<CharInt> text = TextStatAnalyze.symbolsContainAnalyze(input);
            System.out.println(text);
            System.out.println(text.size());
            int a=0;
            int b=0;
            for (int i = 0; i < text.size(); i++) {
                a+=textOrig.get(i).getSymbolQuantity();
                b+=text.get(i).getSymbolQuantity();
            }
            HashMap<Character, Character> symbolsToChange = new HashMap<>();
            for (int i = 0; i < Math.min(textOrig.size(), text.size()); i++) {
                symbolsToChange.put(text.get(i).getSymbol(),textOrig.get(i).getSymbol());
            }
            System.out.println(symbolsToChange);
            for (int i = 0; i < text.size(); i++) {
                int aa = (textOrig.get(i).getSymbolQuantity());
                int bb =(text.get(i).getSymbolQuantity());
                textOrig.get(i).setSymbolPercentQuantity(aa*100/a);
                text.get(i).setSymbolPercentQuantity(bb*100/b);
            }
            System.out.println(textOrig);
            System.out.println(text);
            return symbolsToChange;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
