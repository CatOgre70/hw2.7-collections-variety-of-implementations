package com.example.hw2_7collectionsvarietyofimplementations.model;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class IdDatabase {

    private final List<String> idDb;
    int lastIndex;

    public IdDatabase() {
        idDb = new ArrayList<>();
        lastIndex = 0;
    }

    public String generateNewId(){

        Formatter f = new Formatter();
        String s;
        if(idDb.isEmpty()){
            f.format("%06d", 1);
            lastIndex = 1;
        } else {
            lastIndex++;
            f.format("%06d", lastIndex);
        }
        s = f.toString();
        idDb.add(s);
        return s;
    }

    int getLastId(){
        return lastIndex;
    }

    int getFirstAvailableId(){
        return lastIndex + 1;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("idDb = [ ");
        for (String s : idDb ) {
            str.append(s);
            str.append(" ");
        }
        str.append("]");
        return str.toString();
    }

}
