package ru.javarush.cryptoanaliser.belitsky.alphabet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumber {

    public static boolean isNumber(String choise) {

        Pattern pattern = Pattern.compile("[^0-9]+");
        Matcher matcher = pattern.matcher(choise);
        return !matcher.find();
    }
}
