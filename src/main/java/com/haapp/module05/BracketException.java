package com.haapp.module05;

import java.util.function.Supplier;

public class BracketException extends Exception {

    public BracketException(String message){
        super("ERROR: " + message);
    }
}
