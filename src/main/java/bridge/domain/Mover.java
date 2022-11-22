package bridge.domain;

import bridge.dto.GameResult;

public class Mover {

    private final Bridge bridge;
    private int columnPosition;

    public Mover(Bridge bridge) {
        this.bridge = bridge;
        columnPosition = 0;
    }

    public Boolean move(String command) {
        columnPosition++;
        return bridge.compare(command, columnPosition - 1);
    }

    public GameResult resultOfMove(boolean isMatch) {
        if (isMatch) {
            return bridge.getMatchedPathResult(columnPosition);
        }
        return bridge.getUnMatchedPathResult(columnPosition);
    }

    public void init() {
        columnPosition = 0;
    }

    public static Mover from(Bridge bridge) {
        return new Mover(bridge);
    }
}
