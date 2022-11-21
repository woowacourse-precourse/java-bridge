package bridge.domain;

import static bridge.domain.PlayerStatus.*;

public class Player {
    private int position;
    private int tryCount = 0;
    private PlayerStatus status;

    public void init() {
        position = 0;
        status = PLAYING;
        tryCount++;
    }

    public PlayerStatus move() {
        position++;
        return status;
    }

    public int getNextPosition() {
        return position;
    }

    public PlayerStatus fail() {
        status = FAIL;
        return status;
    }
}
