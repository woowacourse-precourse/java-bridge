package bridge.domain;

import static bridge.utils.Constant.UP;

import bridge.utils.validator.MoveValidator;


public class Move {
    private final String move;

    public Move(String move){
        new MoveValidator(move);
        this.move = move;
    }

    public boolean goToNextMove(String BridgeStep){
        if(BridgeStep == this.move){
            return true;
        }
        return false;
    }
    
}
