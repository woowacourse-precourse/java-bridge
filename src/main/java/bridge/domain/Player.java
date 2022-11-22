package bridge.domain;

import static bridge.domain.PlayerStatus.*;

public class Player {
    private int position;
    private PlayerStatus status;

    public void init() {
        position = 0;
        status = PLAYING;
        status.addTryCount();
    }

    public PlayerStatus success() {
        position++;
        return status;
    }

    public PlayerStatus fail() {
        status = FAIL;
        return status;
    }

    public void finish() {
        status = SUCCESS;
    }

    public int getNextPosition() {
        return position;
    }

    public PlayerStatus getStatus() {
        return status;
    }
}