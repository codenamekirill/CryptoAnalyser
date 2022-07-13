package ru.javarush.cryptoanaliser.belitsky.Manager;

import ru.javarush.cryptoanaliser.belitsky.application.Menu;
import ru.javarush.cryptoanaliser.belitsky.decrypt.Decrypt;
import ru.javarush.cryptoanaliser.belitsky.encrypt.RollWithKey;

public class CommandManager {

    private final Menu option;

    public CommandManager(Menu option) {
        this.option = option;
    }

    public void runCommand() {
        switch (option) {
            case ENCRYPT -> RollWithKey.rollWithKey(Menu.source, Menu.destination, Menu.inputKey());
            case DECRYPT_WITH_KEY -> Decrypt.decryptWithKey(Menu.source, Menu.destination);
            case DECRYPT_BRUTFORCE -> Decrypt.decryptBrutForce(Menu.source,Menu.destination);

            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

}
