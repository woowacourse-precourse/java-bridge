package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userMoveState;
    private List<String> moveMatchState;

    public User() {
        this.userMoveState = new ArrayList<>();
        this.moveMatchState = new ArrayList<>();
    }
}
