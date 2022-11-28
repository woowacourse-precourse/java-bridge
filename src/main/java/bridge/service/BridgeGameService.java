package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameManager;
import bridge.domain.Direction;
import bridge.domain.UserBridge;
import java.util.List;

public class BridgeGameService {
    private BridgeGameManager bridgeGameManager;
    private UserBridge userBridge;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private Bridge bridge;

    public BridgeGameService(BridgeGameManager bridgeGameManager, UserBridge userBridge) {
        this.bridgeGameManager = bridgeGameManager;
        this.userBridge = userBridge;
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    private static Direction findDirection(Bridge bridge, BridgeGameManager bridgeGameManager) {
        String now = bridge.getNow(bridgeGameManager);
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

        if (!(direction == now)) {
            bridgeGameManager.gameFail();
            return true;
        }
        return false;
    }

    public boolean play() {
        return userBridge.size() < bridge.getSize();
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
        bridge = new Bridge(bridgeMaker.makeBridge(suggestBridgeSize));
    }
}
