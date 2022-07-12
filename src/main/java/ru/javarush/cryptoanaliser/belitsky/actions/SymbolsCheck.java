package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;

public class SymbolsCheck {//2 метода проверок на правильность расшифровки

    public static boolean pairCheck(char symbol1, char symbol2) {

        if (Alphabet.symbolsContainCheck(symbol1) && symbol2 != ' ') return false;
        else return symbol1 != ' ' || !Alphabet.yodle(symbol2);
    }

    public static boolean trioCheck(char symbol1, char symbol2, char symbol3) {

        return symbol1 != ' ' || symbol3 != ' ' || Alphabet.getOneLetterWords(symbol2);
    }
}