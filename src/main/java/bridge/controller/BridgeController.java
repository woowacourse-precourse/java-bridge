package bridge.controller;

import bridge.model.Row;

public class BridgeController {

    void validateNumeric(String input){
        if(!input.matches("^[0-9]")){
            throw new IllegalArgumentException();
        }}
    void validateLetter(String input){
        if(!Row.isValidateLetter(input)){
            throw new IllegalArgumentException();
        }
    }
}
