package bridge.presentation.dto;

public class GameCommand {
    private String command;
    public GameCommand(String input){
        validate(input);
        command=input;
    }
    private void validate(String target){

    }
    public String getCommand() {
        return command;
    }
}
