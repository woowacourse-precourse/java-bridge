package bridge.Domain;

public class Player {
    private int position;

    public Player() {
        this.position = 0;
    }

    public void movePlayer() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

}
