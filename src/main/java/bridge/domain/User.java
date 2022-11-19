package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userMoveState;
    private List<Boolean> moveMatchState;

    public User() {
        this.userMoveState = new ArrayList<>();
        this.moveMatchState = new ArrayList<>();
    }

    public void move(String moving) {
        userMoveState.add(moving);
    }

    public int getUserLastIndex() {
        return userMoveState.size() - 1;
    }

    public void saveState(boolean checkCorrectMoving) {
        moveMatchState.add(checkCorrectMoving);
    }

    public String getUserMoveState(int index) {
        return userMoveState.get(index);
    }

    public boolean getMoveMatchState(int index) {
        return moveMatchState.get(index);
    }

    public void clear() {
        moveMatchState.clear();
        userMoveState.clear();
    }
}
