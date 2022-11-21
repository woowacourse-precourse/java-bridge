package bridge.model;

import bridge.util.Message;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMovable(int nowPosition, String nextMove) {
        if (nowPosition < 0) throw new IllegalStateException(Message.ILLEGAL_PLAYER_POSITION_ERROR_MESSAGE);
        if (isFinish(nowPosition)) throw new IllegalStateException(Message.ALREADY_FINISH_PLAYER_ERROR_MESSAGE);

        String correctNextMove = bridge.get(nowPosition);

        return correctNextMove.equals(nextMove);
    }

    public boolean isFinish(int nowPosition) {
        return nowPosition >= bridge.size();
    }

    public int length() {
        return bridge.size();
    }

}
