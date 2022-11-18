package bridge.domain;

import bridge.utils.validator.MoveValidator;
import java.util.List;

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
