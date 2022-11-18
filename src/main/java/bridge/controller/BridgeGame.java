package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.Position;
import bridge.domain.Result;
import bridge.domain.UserPosition;

public class BridgeGame {
    private Bridge bridge;
    private UserPosition userPosition;
    private int TryNumber = 0;

    private BridgeGame (Bridge bridge,UserPosition userPosition) {
        this.bridge = bridge;
        this.userPosition = userPosition;
    }
    public BridgeGame start(Bridge bridge, UserPosition userPosition) {
        return new BridgeGame(bridge, userPosition);
    }

    public Result move(Position position) {
        userPosition.move(position);
        return bridge.play(position);
    }

    public void retry() {
        TryNumber += 1;
        userPosition.reset();
    }

    public int end() {
        return TryNumber;
    }
}
