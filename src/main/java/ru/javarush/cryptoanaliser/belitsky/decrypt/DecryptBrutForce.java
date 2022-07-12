package ru.javarush.cryptoanaliser.belitsky.decrypt;

import ru.javarush.cryptoanaliser.belitsky.actions.FileCheck;
import ru.javarush.cryptoanaliser.belitsky.actions.FinalTextWrite;
import ru.javarush.cryptoanaliser.belitsky.actions.RollToCheck;

public class DecryptBrutForce {//брутфорс расшифровка

    public static void decryptBF (String src, String dest){
        if(FileCheck.fileCheck(src,dest)==-1){
            System.out.println("Создайтие файл с текстом или измените к нему путь");
            return;
        }
        int key/*= RollToCheck.rollToCheck(src)*/;
       if((key = RollToCheck.rollToCheck(src))==-1){
            System.out.println("Брут форс не сработал");
            return;
        }
        FinalTextWrite.finalTextWrite(src,dest,key);


    }


}
