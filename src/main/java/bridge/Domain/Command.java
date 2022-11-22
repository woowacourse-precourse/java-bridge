package bridge.Domain;

import bridge.Controller.Validation;

public class Command {
    private String command;

    public Command(String command){
        Validation.validateGameCommand(command);
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
