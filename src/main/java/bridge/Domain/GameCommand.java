package bridge.Domain;

import bridge.Controller.Validation;

public class GameCommand {
    String command;

    public GameCommand(String command){
        Validation.validateReadGameCommand(command);
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
