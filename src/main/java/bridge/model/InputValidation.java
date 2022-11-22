package bridge.model;

import bridge.constant.BridgeLengthSizeStatus;
import bridge.constant.CmdStatus;
import bridge.constant.ErrorStatus;

public class InputValidation {

    public void bridgeLengthInputIsNumber(String lengthInput){
        if (!lengthInput.matches("[0-9]+")){
            throw new IllegalArgumentException(ErrorStatus.BridgeLength.getDes());
        }
    }
    public void bridgeLengthValid(int lengthSize){
        if (!BridgeLengthSizeStatus.bridgeLengthSizeValid(lengthSize)){
            throw new IllegalArgumentException(ErrorStatus.BridgeLength.getDes());
        }
    }

    public void moveValid(String cmd){
        if (!CmdStatus.moveValidation(cmd)){
            throw new IllegalArgumentException(ErrorStatus.MoveCmd.getDes());
        }

    }

    public void reGameCmdValid(String cmd){
        if (!CmdStatus.reGameValidation(cmd)) {
            throw new IllegalArgumentException(ErrorStatus.ReGame.getDes());
        }
    }
}
