package bridge.domain;

import java.util.List;

public class User {

    private int position = 0;
    private List<String> up;
    private List<String> down;
    private int numberOfTrial = 0;

    public int getPosition() {
        return this.position;
    }

    public void move() {
        position++;
    }
}
