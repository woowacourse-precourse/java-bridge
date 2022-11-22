package bridge.model;

public class Count {
    private int count;

    public Count() {
        this.count = 0;
    }

    public void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
