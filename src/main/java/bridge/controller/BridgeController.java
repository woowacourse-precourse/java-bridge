package bridge.controller;

public class BridgeController {

    void validateNumeric(String input){
        if(!input.matches("^[0-9]")){
            throw new IllegalArgumentException();
        }}
}
