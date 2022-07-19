package ru.javarush.cryptoanalyser.belitsky.application;

import ru.javarush.cryptoanalyser.belitsky.actions.Actions3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public enum Menu {
    ENCRYPT,
    DECRYPT_WITH_KEY,
    DECRYPT_BRUTFORCE,
    DECRYPT_STATISTIC,
    EXIT;


    public static String source  /*System.getProperty("user.dir")*/;
    public static String destination;
    public static final String SOMETHING_WENT_WRONG = "Ой, чтото пошло не так. :'(";
    public static final String INPUT_SOURCE_ADRESS = "Введите адрес исходного файла : ";
    public static final String INPUT_DEST_ADRESS = "Введите адреc результата, если его не существует он будет создан : ";
    public static final String INPUT_COMMAND = "Введите команду или ее номер в строку : ";
    public static final String INPUT_KEY = "Введите ключ : ";
    public static final String RESULT_AT = "Результат находится по адресу ";

    public static final String END = "Программа завершена";

    public static void printMenu() {

        for (Menu value : Menu.values()) {
            System.out.println(value.ordinal() + "  " + value);
        }
    }

    public static Menu menuNavigation() {//навигация по меню.
        while (true) {
            System.out.println(INPUT_COMMAND);
            Scanner scanner = new Scanner(System.in);
            String choise = scanner.nextLine();
            if (Actions3.isNumber(choise) && Integer.parseInt(choise) >= 0 && Integer.parseInt(choise) < Menu.values().length) {
                for (Menu value : Menu.values()) {
                    if (value.ordinal() == Integer.parseInt(choise)) return value;
                }
            } else {
                for (Menu value : Menu.values()) {
                    if (choise.equalsIgnoreCase(value.name())) return value;
                }
            }
            System.out.println(SOMETHING_WENT_WRONG);
        }
    }

    public static void filePathCheck() {
        while (true) {
            System.out.println(INPUT_SOURCE_ADRESS);
            Scanner scanner = new Scanner(System.in);
            source = scanner.nextLine();

            if (source.equals(""))source = "text.txt";
            Path pathSrc = Path.of(source);
            if(!pathSrc.isAbsolute())pathSrc = Path.of(source).toAbsolutePath();
            System.out.println(pathSrc);
            if (Files.notExists(pathSrc)) {
                System.out.println(SOMETHING_WENT_WRONG);
                continue;
            }
            System.out.println(INPUT_DEST_ADRESS);
            destination = scanner.nextLine();
            if (destination.equals(""))destination = "text1.txt";

            Path pathDest = Path.of(destination);
            if(!pathDest.isAbsolute())pathDest = Path.of(destination).toAbsolutePath();
            if (Files.exists(pathDest)) {
                try {
                    Files.delete(pathDest);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Files.createFile(pathDest);
                System.out.println(RESULT_AT + pathDest);
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int inputKey() {
        while (true) {
            System.out.println(INPUT_KEY);
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            if (!Actions3.isNumber(key)) {
                System.out.println(SOMETHING_WENT_WRONG);
            } else return Integer.parseInt(key);
        }
    }
}
