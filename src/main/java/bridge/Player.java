package bridge;

public class Player {
    private int position;
    private String direction;

    public Player() {
        this.position = 0;
    }

    public boolean move(String u) {
        this.position++;
        this.direction = u;
        return true;
    }

    public int getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }
}
