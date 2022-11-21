package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameManager;
import bridge.domain.BridgeMaker;
import bridge.domain.Direction;
import bridge.domain.UserBridge;
import java.util.List;

public class BridgeGameService {
    private BridgeGameManager bridgeGameManager;
    private BridgeGame bridgeGame;
    private UserBridge userBridge;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;

    public BridgeGameService(BridgeGameManager bridgeGameManager, BridgeGame bridgeGame, UserBridge userBridge,
                             BridgeMaker bridgeMaker) {
        this.bridgeGameManager = bridgeGameManager;
        this.bridgeGame = bridgeGame;
        this.userBridge = userBridge;
        this.bridgeMaker = bridgeMaker;
    }

    private static Direction findDirection(List<String> bridge, BridgeGameManager bridgeGameManager) {
        String now = bridge.get(bridgeGameManager.getStep());
        return Direction.from(now);
    }

    public UserBridge move(String moving) {
        Direction direction = findDirection(bridge, bridgeGameManager);
        Direction now = Direction.valueOf(moving);
        bridgeGame.move(userBridge, direction, now);
        return userBridge;
    }

    public boolean fail(String moving) {
        Direction direction = findDirection(bridge, bridgeGameManager);
        Direction now = Direction.valueOf(moving);

        if (!direction.equals(now)) {
            bridgeGameManager.gameFail();
            return true;
        }
        return false;
    }

    public boolean play() {
        return userBridge.size() < bridge.size();
    }

    public boolean isQuit(String retry) {
        return bridgeGame.retry(bridgeGameManager, userBridge, retry);
    }

    public int getCount() {
        return bridgeGameManager.getCount();
    }

    public void increaseStep() {
        bridgeGameManager.increaseStep();
    }

    public UserBridge getUserBridge() {
        return userBridge;
    }

    public void makeBridge(int suggestBridgeSize) {
        this.bridge = bridgeMaker.makeBridge(suggestBridgeSize);
    }
}
