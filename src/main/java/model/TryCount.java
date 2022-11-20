package model;

public class TryCount {
    private int count;

    public TryCount() {
        this.count = 1;
    }

    public void increase() {
        this.count++;
    }

    @Override
    public String toString() {
        return Integer.toString(count);
    }
}
