package com.haapp.module05;

import java.util.Scanner;
import java.util.Stack;

public class Module05 {

    private static final String OPEN_BRACKETS = "({[<";
    private static final String CLOSE_BRACKETS = ")}]>";
    private static final String SEPARATOR_LINE = "------------------------------------------------------------------";

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            separate();
            System.out.println("Please, type a string with some brackets and press ENTER:");
            String inComeLineFromConsole = in.nextLine();
            if(checkBracket(inComeLineFromConsole)){
                System.out.println("INFO: The brackets are placed correctly in your string: " + inComeLineFromConsole);
            }
            separate();
        } catch (BracketException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void separate (){
        System.out.println(SEPARATOR_LINE);
    }

    private static boolean checkBracket(String inComeLineFromConsole) throws BracketException {

        char[] inCome = inComeLineFromConsole.toCharArray();
        Stack<Character> bracketStack = new Stack<Character>();
        Stack<Integer> positionStack = new Stack<Integer>();

        int position = 0;

        for (Character character:inCome) {
            position++;
            if (OPEN_BRACKETS.contains(character.toString())){
                bracketStack.push(character);
                positionStack.push(position);
            }
            if (CLOSE_BRACKETS.contains(character.toString())){
                if (bracketStack.isEmpty()){
                    throw new BracketException("Unexpected bracket '" + character + "' in position " + position);
                }
                if ((character - bracketStack.pop()) > 2){
                    throw new BracketException("Unexpected bracket '" + character + "' in position " + position);
                };
                positionStack.pop();
            }
        }
        if (!bracketStack.isEmpty()){
            throw new BracketException("Not closes bracket '" + bracketStack.pop() + "' in position " + positionStack.pop());
        }
        return true;
    }
}
