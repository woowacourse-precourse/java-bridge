package bridge.domain;

public class User {
    private int step = 0;
    private boolean live = true;

    public void init() {
        this.step = 0;
        this.live = true;
    }

    public void move() {

    }

    public int getStep() {
        return this.step;
    }

    public boolean isLive() {
        return this.live;
    }
}
