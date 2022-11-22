package bridge.controller;

import static bridge.data.Command.QUIT;
import static bridge.data.Command.RESTART;
import static bridge.data.Glass.DOWN;
import static bridge.data.Glass.UP;
import static bridge.data.Message.ERROR_COMMAND;
import static bridge.data.Message.ERROR_HEAD;
import static bridge.data.Message.ERROR_MOVE;
import static bridge.data.Message.ERROR_SIZE;

import bridge.view.BridgeView;

public class ExceptionHandler {


    public String reEnter(BridgeView view, IllegalArgumentException error){
        String errorMessage = error.getMessage();

        while(true){
            try{
                view.printErrorMessage(ERROR_HEAD.OF() + errorMessage);
                return viewControlByError(view, errorMessage);
            }
            catch(IllegalArgumentException e){ continue;}
        }
    }

    public String viewControlByError(BridgeView view, String errorMessage){
        if(errorMessage.equals(ERROR_SIZE.OF())) return validBridgeSize(view.sizeIO());
        if(errorMessage.equals(ERROR_MOVE.OF())) return validMoving(view.moveIO());
        return validGameCommand(view.commandIO());
    }

    public String validBridgeSize(String size){
        int newSize = excParseInt(size);
        if(newSize < 3 || newSize > 20) throw new IllegalArgumentException(ERROR_SIZE.OF());
        return size;
    }

    public String validMoving(String move){
        if(!move.equals(UP.MOVE()) && !move.equals(DOWN.MOVE())) throw new IllegalArgumentException(ERROR_MOVE.OF());
        return move;
    }

    public String validGameCommand(String command){
        if(!command.equals(RESTART.KEY()) && !command.equals(QUIT.KEY())) throw new IllegalArgumentException(ERROR_COMMAND.OF());
        return command;
    }

    public static Integer excParseInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_SIZE.OF());
        }
    }

}
