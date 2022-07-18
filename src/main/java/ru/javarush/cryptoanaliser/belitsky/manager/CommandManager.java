package ru.javarush.cryptoanaliser.belitsky.manager;

import ru.javarush.cryptoanaliser.belitsky.actions.Actions;
import ru.javarush.cryptoanaliser.belitsky.actions.Actions2;
import ru.javarush.cryptoanaliser.belitsky.application.Menu;

public class CommandManager {

    private final Menu option;

    public CommandManager(Menu option) {
        this.option = option;
    }

    public void runCommand() {

        switch (option) {
            case ENCRYPT -> Actions2.rollWithKey(Menu.source, Menu.destination, Menu.inputKey());
            case DECRYPT_WITH_KEY -> Actions.decryptWithKey(Menu.source, Menu.destination);
            case DECRYPT_BRUTFORCE -> Actions.decryptBrutForce(Menu.source,Menu.destination);
            case DECRYPT_STATISTIC -> Actions.decryptStatic("C:\\test\\fileorig.txt",Menu.source,Menu.destination);
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

}
