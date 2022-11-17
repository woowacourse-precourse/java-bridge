package bridge.domain;

import java.util.List;

public class Move {
    private final String move;

    public Move(String move){
        this.move = move;
    }

    public boolean goToNextMove(String BridgeStep){
        if(BridgeStep == this.move){
            return true;
        }
        return false;
    }

}
