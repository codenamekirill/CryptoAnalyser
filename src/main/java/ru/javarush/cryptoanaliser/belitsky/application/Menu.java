package ru.javarush.cryptoanaliser.belitsky.application;

public enum Menu {
    ENCRYPT,
    DECRYPT,
    EXIT,
    BRUTFORCE,
    STATISTIC;

    public static void printMenu(){

        for (Menu value : Menu.values()) {
            System.out.println(value.ordinal()+"  "+value);
        }
        System.out.println("Введите команду или ее номер в строку : ");
        

    }


}
