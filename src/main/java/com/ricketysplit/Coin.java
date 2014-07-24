package com.ricketysplit;

/**
 * Created by r.harkins on 7/24/2014.
 */
public class Coin implements Comparable<Coin>{

    private final int value;
    private final String name;
    private final String pluralName;

    public Coin(String name, String pluralName, int value){
        this.name = name;
        this.pluralName = pluralName;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public String getName(){
        return name;
    }

    public String getPluralName(){
        return pluralName;
    }

    @Override
    public int compareTo(Coin o) {
        int compareValue = ((Coin) o).getValue();
        return compareValue - this.value;
    }
}
