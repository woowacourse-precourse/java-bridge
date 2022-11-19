package bridge.domain;

import java.util.List;

public class User {
    private List<String> userMoveState;
    private List<String> moveMatchState;

    public User(List<String> userMoveState, List<String> moveMatchState) {
        this.userMoveState = userMoveState;
        this.moveMatchState = moveMatchState;
    }
}
