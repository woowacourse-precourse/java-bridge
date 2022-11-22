package bridge.model;

import bridge.util.Message;

import java.util.List;

public class Player {

    private int position;
    private int tryCount;
    private Bridge bridge;

    public Player(Bridge bridge) {
        this.bridge = bridge;
        this.position = 0;
        this.tryCount = 1;
    }

    public Player(List<String> bridge) {
        this.bridge = new Bridge(bridge);
        this.position = 0;
        this.tryCount = 1;
    }

    public boolean move(String nextMove) {
        boolean flag = bridge.isMovable(position, nextMove);
        if (flag) position += 1;
        return flag;
    }

    public void restart() {
        tryCount++;
    }

    public boolean isFinish() {
        return bridge.isFinish(position);
    }

    @Override
    public String toString() {
        String gameFinishMessage = Message.getGameFinishMessage(isFinish());
        String tryCountMessage = Message.getTryCountMessage(tryCount);
        return String.join("\n", gameFinishMessage, tryCountMessage);
    }
}
