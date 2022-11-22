package bridge.presentation.dto;

import bridge.support.Validator;

public class GameCommand {
    private final String command;
    public GameCommand(String input){
        validate(input);
        command=input;
    }
    private void validate(String target){
        Validator.checkCommandAlphabet(target);
    }
    public String getCommand() {
        return command;
    }
}
