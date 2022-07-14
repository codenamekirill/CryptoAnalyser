package ru.javarush.cryptoanaliser.belitsky.application;

import ru.javarush.cryptoanaliser.belitsky.Manager.CommandManager;

public class Application {

    public static void run() {
        while(true){
            Menu.printMenu();
            Menu menuChoise = Menu.menuNavigation();
            if(menuChoise==Menu.EXIT){
                System.out.println(Menu.END );
                break;
            }
            Menu.filePathCheck();
            CommandManager commandManager = new CommandManager(menuChoise);
            long start=System.currentTimeMillis();
            commandManager.runCommand();
            long finish=System.currentTimeMillis();
            System.out.println(finish-start);
        }
    }


}
