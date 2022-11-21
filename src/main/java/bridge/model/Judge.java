package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    List<String> bridge;
    List<String> userBridge;


    public Judge(List<String> bridge) {
        this.bridge = bridge;
        this.userBridge = new ArrayList<>();
    }

    public void initUserBridge() {
        userBridge = new ArrayList<>();
    }

    public void addUserBridge(Moving moving) {
        userBridge.add(moving.getValue());
    }

    public MoveResult checkIsCorrectMoving(Moving moving) {
        int compareIndex = userBridge.size() - 1;
        if (bridge.get(compareIndex).equals(moving.getValue())) {
            return MoveResult.CORRECT;
        }
        return MoveResult.NOT_CORRECT;
    }


    public boolean isGameEnd(MoveResult moveResult) {
        return moveResult == MoveResult.CORRECT && userBridge.size() != bridge.size();
    }

    public List<String> getUserBridge() {
        return userBridge;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
