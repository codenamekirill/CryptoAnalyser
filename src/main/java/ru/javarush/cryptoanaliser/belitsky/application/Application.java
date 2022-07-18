package ru.javarush.cryptoanaliser.belitsky.application;

import ru.javarush.cryptoanaliser.belitsky.manager.CommandManager;

public class Application {

    public static void run() {
        while (true) {
            Menu.printMenu();
            Menu menuChoise = Menu.menuNavigation();
            if (menuChoise == Menu.EXIT) {
                System.out.println(Menu.END);
                break;
            }
            Menu.filePathCheck();
            CommandManager commandManager = new CommandManager(menuChoise);
            commandManager.runCommand();
        }
    }


}
