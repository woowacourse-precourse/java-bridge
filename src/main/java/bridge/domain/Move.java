package bridge.domain;

import java.util.List;

public class Move {
    private final String move;

    public Move(String move){
        this.move = move;
    }

    private boolean detectMove(List<String> bridge){
        if(bridge.get(0) == this.move){
            return true;
        }
        return false;
    }

}
