package ru.javarush.cryptoanaliser.belitsky.myclasses;

public class CharInt implements Comparable <CharInt>{
    private Character symbol;
    private Integer symbolQuantity;

    private Integer symbolPercentQuantity = 0;

    public CharInt(Character symbol, Integer symbolQuantity/*Integer allSymbols*/){
        this.symbol =symbol;
        this.symbolQuantity =symbolQuantity;
        //this.symbolPercentQuantity=allSymbols/this.symbolQuantity;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public void setSymbolPercentQuantity(Integer symbolPercentQuantity) {
        this.symbolPercentQuantity = symbolPercentQuantity;
    }

    public void setSymbolQuantity(Integer symbolQuantity) {
        this.symbolQuantity = symbolQuantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CharInt charInt = (CharInt) obj;
        return this.symbol.equals(charInt.symbol);
    }

    @Override
    public int hashCode() {
        return this.symbol.hashCode();
    }

    public Integer getSymbolQuantity() {
        return symbolQuantity;
    }

    public Character getSymbol() {
        return symbol;
    }

    private int compare(CharInt first, CharInt second){
        return  first.getSymbolQuantity()< second.getSymbolQuantity()?1:first.getSymbolQuantity()==second.getSymbolQuantity()?0:-1;}
    @Override
    public int compareTo(CharInt o) {
        return compare(this,o);
    }

    @Override
    public String toString() {
        return   symbol + ", " + symbolQuantity +", "+symbolPercentQuantity+"%";
    }
}
