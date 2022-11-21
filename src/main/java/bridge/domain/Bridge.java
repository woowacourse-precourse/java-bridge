package bridge.domain;

import java.util.Arrays;
import java.util.List;

public class Bridge {
    final List<String> bridge; // U D U U
    int position;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
        this.position = -1;
    }

    boolean isEndOfBridge(){// bridgeIndex
        if(position == bridge.size()){
           return true;
        }
        return false;
    }

    boolean isMovable(String moveCommand){ // U 1, D 2 : direction, bridgeIndex
        if(bridge.get(position).equals(moveCommand)){
            return true;
        }
        return false;
    }

    private void increasePosition(){
        this.position++;
    }

    MoveResult getMoveResult(String moveCommand){
        if(isMovable(moveCommand)){
            return MoveResult.SUCCESS;
        }
        return MoveResult.FAIL;
    }

    MoveResult move(String moveCommand){
        increasePosition();
        return getMoveResult(moveCommand);
    }
}
