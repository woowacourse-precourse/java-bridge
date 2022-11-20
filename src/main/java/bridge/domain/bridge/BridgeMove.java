package bridge.domain.bridge;

import bridge.domain.Message;

public class BridgeMove {
    private String move;

    public BridgeMove(String s) {
        validate(s);
        this.move = s;
    }
    public String getDirection() {
        return move;
    }

    private void validate(String s) {
        if (!(s.equals("D") || s.equals("U"))) {
            throw new IllegalArgumentException(Message.ERROR_DIRECTION_OUT_OF_RANGE.get());
        }
    }
}
