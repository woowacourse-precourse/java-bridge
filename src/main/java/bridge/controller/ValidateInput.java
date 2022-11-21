package bridge.controller;

import bridge.model.Column;

public class ValidateInput {
    static int checkNumeric(String input){
        if(!input.matches("^[0-9]")){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
    static String checkLetter(String input){
        if(!Column.isValidateLetter(input)){
            throw new IllegalArgumentException();
        }
        return input;
    }
    static void checkEndLetter(String input){
        if(!input.equals(GameMessage.RETRY) || !input.equals(GameMessage.CLOSE)){
            throw new IllegalArgumentException();
        }
    }
}
