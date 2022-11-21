package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameManager;
import bridge.BridgeMaker;
import bridge.domain.Direction;
import bridge.domain.UserBridge;
import java.util.List;

public class BridgeGameService {
    private BridgeGameManager bridgeGameManager;
    private UserBridge userBridge;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;

    public BridgeGameService(BridgeGameManager bridgeGameManager, UserBridge userBridge) {
        this.bridgeGameManager = bridgeGameManager;
        this.userBridge = userBridge;
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
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
