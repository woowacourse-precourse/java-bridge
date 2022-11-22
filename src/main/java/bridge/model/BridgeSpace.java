package bridge.model;

import java.util.Objects;

public class BridgeSpace {
    String upOrDown;
    Moved myMoved;

    public BridgeSpace(String upOrDown) {
        this.upOrDown = upOrDown;
        this.myMoved = Moved.NOTYET;
    }

    public String getUpOrDown() {
        return upOrDown;
    }

    public Moved getMyMoved() {
        return myMoved;
    }

    public void setMyMoved(Moved myMoved) {
        this.myMoved = myMoved;
    }

    public Moved checkMoving(String userMove) {
        if (userMove.equals(upOrDown)) {
            return Moved.CAN;
        }
        return Moved.CANT;
    }

    public void init() {
        this.myMoved = Moved.NOTYET;
    }
}
