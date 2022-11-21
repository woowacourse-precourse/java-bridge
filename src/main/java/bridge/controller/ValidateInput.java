package bridge.controller;

public class ValidateInput {
    protected int numeric(String input){
        if(!input.matches("^[0-9]")){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
    protected void endLetter(String input){
        if(!input.equals(GameMessage.RETRY) || !input.equals(GameMessage.CLOSE)){
            throw new IllegalArgumentException();
        }
    }
}
