package bridge.model;

public class Position {
    private int x, y;

    public Position() {
        this.x = -1;
        this.y = -1;
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    public void addPositionX() {
        x += 1;
    }

    public void changePositionY(int number) {
        y = number;
    }
}
