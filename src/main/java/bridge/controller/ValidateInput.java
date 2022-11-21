package bridge.controller;

import bridge.model.Column;

public class ValidateInput {
    int numeric(String input){
        if(!input.matches("^[0-9]")){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
    String letter(String input){
        if(!Column.isValidateLetter(input)){
            throw new IllegalArgumentException();
        }
        return input;
    }
    void endLetter(String input){
        if(!input.equals(GameMessage.RETRY) || !input.equals(GameMessage.CLOSE)){
            throw new IllegalArgumentException();
        }
    }
}
