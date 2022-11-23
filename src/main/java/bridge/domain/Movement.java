package bridge.domain;

public class Movement {
    private int moveCount;
    private Moving moving;

    public void saveMoving(Moving moving) {
        moveCount++;
        this.moving = moving;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Moving getMoving() {
        return moving;
    }
}