package bridge;

public class Player {
    private int position;
    public Player() {
        this.position = 0;
    }

    public int move() {
        return position++;
    }
}
