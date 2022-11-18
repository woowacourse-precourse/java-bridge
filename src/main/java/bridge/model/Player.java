package bridge.model;

public class Player {
    private Position position;
    private int tryCount;

    public Player() {
        this.position = new Position();
        this.tryCount = 0;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition() {
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount() {
        this.tryCount += 1;
    }

    public void initializePosition() {
        this.position = new Position();
    }
}
