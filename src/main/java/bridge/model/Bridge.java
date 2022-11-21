package bridge.model;

import bridge.model.constant.Status;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private User user;
    private Status status;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.user = new User();
        this.status = Status.GAME_PROCESSING;
    }

    public boolean isMovable(String move) {
        user.addMove(move);
        if (!bridge.get(user.getMoveCount() - 1).equals(move)) {
            this.status = Status.GAME_OVER;
            return false;
        }
        if (bridge.size() == user.getMoveCount()) {
            this.status = Status.GAME_FINISHED;
        }
        return true;
    }
}
