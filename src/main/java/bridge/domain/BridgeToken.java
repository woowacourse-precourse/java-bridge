package bridge.domain;

public class BridgeToken {

    private final Direction direction;

    private final boolean correct;

    public BridgeToken(Direction direction, boolean correct) {
        this.direction = direction;
        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }

    public Direction getDirection() {
        return direction;
    }

}
