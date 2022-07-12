package ru.javarush.cryptoanaliser.belitsky.actions;

import ru.javarush.cryptoanaliser.belitsky.alphabet.Alphabet;

public class Roll {//покрутить алфавит

    public static char roll (int index, int key){
        if(index+key<0)index+=Alphabet.getSize();
       return Alphabet.get((index + key) % Alphabet.getSize());
    }

}
