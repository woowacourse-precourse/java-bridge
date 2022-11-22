package bridge.domain;

public class Count {

    private final static int START_INDEX = 1;

    private int count;

    public Count() {
        this.count = START_INDEX;
    }

    public void increase() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}
