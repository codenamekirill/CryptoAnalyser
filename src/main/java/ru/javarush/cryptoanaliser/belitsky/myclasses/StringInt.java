package ru.javarush.cryptoanaliser.belitsky.myclasses;

public class StringInt implements Comparable<StringInt>{
    private String word;
    private Integer wordsQuantity;

    //private Integer wordsPersentageQuantity;

    public StringInt(String symbol, Integer symbolQuantity/*Integer allSymbols*/){
        this.word =symbol;
        this.wordsQuantity =symbolQuantity;
        //this.wordsPersentageQuantity =allSymbols/this.wordsQuantity;
    }

    public Integer getWordsQuantity() {
        return wordsQuantity;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setWordsQuantity(Integer wordsQuantity) {
        this.wordsQuantity = wordsQuantity;
    }

    private int compare(StringInt first, StringInt second){
        return  first.getWordsQuantity()< second.getWordsQuantity()?1:first.getWordsQuantity()==second.getWordsQuantity()?0:-1;}

    @Override
    public int compareTo(StringInt o) {
        return compare(this,o);
    }
}
