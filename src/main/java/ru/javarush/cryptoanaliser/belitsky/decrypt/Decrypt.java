package ru.javarush.cryptoanaliser.belitsky.decrypt;

import ru.javarush.cryptoanaliser.belitsky.actions.FinalTextWrite;
import ru.javarush.cryptoanaliser.belitsky.actions.RollToCheck;
import ru.javarush.cryptoanaliser.belitsky.application.Menu;
import ru.javarush.cryptoanaliser.belitsky.encrypt.RollWithKey;

public class Decrypt {

    public static void decryptBrutForce (String src, String dest){
        int key;
       if((key = RollToCheck.rollToCheck(src))==-1){
            System.out.println("Брут форс не сработал");
            return;
        }
        FinalTextWrite.finalTextWrite(src,dest,key);
    }

    public static void decryptWithKey(String src, String dest){
        int key = Menu.inputKey();
        RollWithKey.rollWithKey(src,dest,(key*-1));
    }

    public static void decryptStatic(String src, String dest){

    }

}
