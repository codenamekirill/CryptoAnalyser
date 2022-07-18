package ru.javarush.cryptoanaliser.belitsky.alphabet;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Dictionary {

    public static void wordsAnalyze (String src){ //составляет карту слов с вхождениями
        try(FileReader input = new FileReader(src)){
            char[] buff = new char[5000];
            HashMap<String,Integer> wordsMap = new HashMap<>();
            while(input.ready()){
                input.read(buff);
                StringTokenizer stringTokenizer = new StringTokenizer(String.valueOf(buff));
                while(stringTokenizer.hasMoreTokens()){
                    String word = stringTokenizer.nextToken();
                    String [] parts = word.split(Alphabet.symbolsStringReturn());//отрезает символы в конце слова
                    word=parts[0];
                    if(wordsMap.containsKey(word)){
                        Integer value = wordsMap.get(word);
                        value++;
                        wordsMap.put(word,value);
                    }
                    else wordsMap.put(word,1);
                }

            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

}
