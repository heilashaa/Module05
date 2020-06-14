package com.haapp.module05;

public class BracketException extends Exception{

    public BracketException(String message){
        super("ERROR: " + message);
    }
}
