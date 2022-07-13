package ru.javarush.cryptoanaliser.belitsky.encrypt;

import ru.javarush.cryptoanaliser.belitsky.actions.FinalTextWrite;

public class RollWithKey {//работа с известным ключом


    public static void rollWithKey(String src, String dest, int key) {

        FinalTextWrite.finalTextWrite(src,dest,key);
    }

}
