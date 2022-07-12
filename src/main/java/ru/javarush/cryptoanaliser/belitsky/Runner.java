package ru.javarush.cryptoanaliser.belitsky;

import ru.javarush.cryptoanaliser.belitsky.application.Menu;
import ru.javarush.cryptoanaliser.belitsky.encrypt.RollWithKey;

public class Runner {

    public static void main(String[] args){

       RollWithKey.rollWithKey("K:\\text.txt","K:\\text2.txt",12, Menu.ENCRYPT);
        RollWithKey.rollWithKey("K:\\text2.txt","K:\\text3.txt",12,Menu.DECRYPT);
      // DecryptBrutForce.decryptBF("K:\\text2.txt","K:\\text3.txt");
      // Menu.printMenu();
    }
}
