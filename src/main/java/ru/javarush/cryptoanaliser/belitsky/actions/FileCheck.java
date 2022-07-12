package ru.javarush.cryptoanaliser.belitsky.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCheck {//проверяет есть ли источник и создает файл результат

    public static int fileCheck (String src, String dest){
        if (Files.notExists(Path.of(src))) return -1;
        if (Files.exists(Path.of(dest))) {
            try {
                Files.delete(Path.of(dest));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.createFile(Path.of(dest));
            System.out.println("Результат находится по адресу "+dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

}
