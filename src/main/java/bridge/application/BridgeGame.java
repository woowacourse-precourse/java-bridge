package bridge.application;

import bridge.domain.Bridge;
import bridge.domain.Count;
import bridge.domain.Move;
import bridge.domain.Moving;
import bridge.domain.UserBridge;

public class BridgeGame {

    private final Bridge bridge;
    private Count count;
    private UserBridge userBridge;
    private Moving moving;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.count = new Count();
        this.userBridge = new UserBridge();
        this.moving = new Moving();
    }

    public Moving move(Move move) {
        userBridge.add(move.getCommand());
        moving.add(move, bridge.distinguish(userBridge.getCurrentIndex(), move));
        return moving;
    }

    public void retry() {
    }

}
