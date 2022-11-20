package bridge.controller;

import bridge.model.Row;

public class BridgeController {
    private static final String RETRY = "R";
    private static final String END = "Q";

    void validateNumeric(String input){
        if(!input.matches("^[0-9]")){
            throw new IllegalArgumentException();
        }}
    void validateLetter(String input){
        if(!Row.isValidateLetter(input)){
            throw new IllegalArgumentException();
        }
    }
    void validateEndLetter(String input){
        if(!input.equals(RETRY) || !input.equals(END)){
            throw new IllegalArgumentException();
        }
    }
}
