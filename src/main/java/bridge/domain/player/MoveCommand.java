package bridge.domain.player;

import bridge.error.ErrorHandler;

public class MoveCommand {
    private String command;
    public MoveCommand(String command){
        this.command = command;
        isValid();
    }
    private void isValid(){
        if (!command.equals("U") && !command.equals("D")){
            ErrorHandler.moveCommandException();
        }
    }
    public boolean getMoveCommandType(){
        return command.equals("D");
    }
}
