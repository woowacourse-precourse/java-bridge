package bridge.domain;

import java.util.List;

public class User {

    private int position = 0;

    public int getPosition() {
        return this.position;
    }

    public void move() {
        position++;
    }

    public void returnStart() {
        position = 0;
    }
}
