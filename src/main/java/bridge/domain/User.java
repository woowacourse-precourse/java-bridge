package bridge.domain;

public class User {

    private int position;
    private int trial;

    public User(int position, int trial) {
        this.position = position;
        this.trial = trial;
    }

    public void updateState() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public int getTrial() {
        return trial;
    }
}
