package ru.javarush.cryptoanaliser.belitsky.application;

import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;
import ru.javarush.cryptoanaliser.belitsky.alphabet.IsNumber;

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

public static long start = 0L;
    public static long finish = 0L;
    public static long time=finish-start;
    public static String source;
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
            if (IsNumber.isNumber(choise) && Integer.parseInt(choise) >= 0 && Integer.parseInt(choise) < Menu.values().length) {
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
            source = "c:\\test\\"+scanner.nextLine();
            if (Files.notExists(Path.of(source))) {
                System.out.println(SOMETHING_WENT_WRONG);
                continue;
            }
            System.out.println(INPUT_DEST_ADRESS);
            destination = "c:\\test\\"+scanner.nextLine();


            Path path = Path.of(destination);
            if (Files.exists(path)) {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Files.createFile(path);
                System.out.println(RESULT_AT + destination);
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int inputKey (){
        while (true){
            System.out.println(INPUT_KEY);
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            if (!IsNumber.isNumber(key)) {
                System.out.println(SOMETHING_WENT_WRONG);
            }
            else return Integer.parseInt(key);
        }
    }
}
