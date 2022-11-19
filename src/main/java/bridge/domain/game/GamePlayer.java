package bridge.domain.game;

public class GamePlayer {
    private int position;
    private int trial;
    private boolean movable;

    private GamePlayer(int position, int trial, boolean movable) {
        this.position = position;
        this.trial = trial;
        this.movable = movable;
    }

    public static GamePlayer withDefaultValue() {
        return new GamePlayer(0, 1, true);
    }

    public int getPosition() {
        return position;
    }

    public synchronized void move() {
        this.position += 1;
    }

    public void stopMoving() {
        this.movable = false;
    }

    public boolean isMovable() {
        return movable;
    }
}
