package ru.javarush.cryptoanalyser.belitsky.application;

import ru.javarush.cryptoanalyser.belitsky.manager.CommandManager;

public class Application {

    public static void run() {
        while (true) {
            Menu.printMenu();
            Menu menuChoise = Menu.menuNavigation();
            if (menuChoise == Menu.EXIT) {
                System.out.println(Menu.END);
                break;
            }
            Menu.filePathCheck(menuChoise);
            CommandManager commandManager = new CommandManager(menuChoise);
            commandManager.runCommand();
            System.out.println(Menu.RESULT_AT + Menu.destination);
        }
    }
}
