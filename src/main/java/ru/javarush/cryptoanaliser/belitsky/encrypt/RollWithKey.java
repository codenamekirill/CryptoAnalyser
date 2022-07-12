package ru.javarush.cryptoanaliser.belitsky.encrypt;

import ru.javarush.cryptoanaliser.belitsky.actions.FileCheck;
import ru.javarush.cryptoanaliser.belitsky.actions.FinalTextWrite;
import ru.javarush.cryptoanaliser.belitsky.application.Menu;

public class RollWithKey {//работа с известным ключом


    public static void rollWithKey(String src, String dest, int key, Menu choise) {
        if(FileCheck.fileCheck(src,dest)==-1){
            System.out.println("Создайтие файл с текстом или измените к нему путь");
            return;
        }

        FinalTextWrite.finalTextWrite(src,dest,key);
    }

}
