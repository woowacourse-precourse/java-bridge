package bridge.domain;

public class Player {
    private int position;

    public Player() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position += 1;
    }
}
