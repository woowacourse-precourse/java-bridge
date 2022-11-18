package bridge.model;

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
        if (userMove == upOrDown) {
            this.myMoved = Moved.CAN;
            return this;
        }
        this.myMoved = Moved.CANT;
        return this;
    }
}
