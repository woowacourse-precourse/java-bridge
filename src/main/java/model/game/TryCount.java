package model.game;

public class TryCount {
    private int count;

    public TryCount() {
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void increase() {
        this.count++;
    }
}
