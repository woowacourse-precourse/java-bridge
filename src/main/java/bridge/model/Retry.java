package bridge.model;

public class Retry {

    private int count;

    public Retry() {
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void countTry() {
        this.count += 1;
    }
}
