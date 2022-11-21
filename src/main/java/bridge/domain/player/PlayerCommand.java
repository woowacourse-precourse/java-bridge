package bridge.domain.player;

import bridge.error.ErrorHandler;

public class PlayerCommand {
    private String command;
    public PlayerCommand(String command){
        this.command = command;
    }
    private void isValid(){
        if (!command.equals("R") && !command.equals("Q")){
            ErrorHandler.playerCommandException();
        }
    }
    public boolean getPlayerCommandType(){
        return command.equals("R");
    }
}
