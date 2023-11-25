package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleController implements Controller {

    private String nextSring = "";
    final List <String> stringList = new ArrayList < >() ;

    @Override
    public void setString(String s) {
        Objects.requireNonNull(s);
        this.nextSring = s;
        this.stringList.add(s);
    }

    @Override
    public String getString() {
        return this.nextSring;
    }

    @Override
    public List<String> getHistory() {
        return stringList;
    }

    @Override
    public void printString() {
        if(nextSring.equals("")) throw new IllegalAccessError("String is unset");
        System.out.println(nextSring);
    }
    
}

