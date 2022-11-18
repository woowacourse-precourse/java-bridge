package bridge.model;

import java.util.Objects;

public class BridgeSpace {
    String upOrDown;
    Moved myMoved;

    public BridgeSpace(String str) {
        this.upOrDown = str;
        this.myMoved = Moved.NOTYET;
    }

    public String getUpOrDown() {
        return upOrDown;
    }

    public Moved getMyMoved() {
        return myMoved;
    }

    public BridgeSpace checkMoving(String userMove) {
        if (Objects.equals(userMove, upOrDown)) {
            this.myMoved = Moved.CAN;
            return this;
        }
        this.myMoved = Moved.CANT;
        return this;
    }

    public void init() {
        this.myMoved = Moved.NOTYET;
    }
}
