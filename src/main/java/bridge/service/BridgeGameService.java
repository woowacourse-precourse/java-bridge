package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeGameManager;
import bridge.constant.Direction;
import bridge.UserBridge;
import java.util.List;

public class BridgeGameService {
    private BridgeMakerService bridgeMakerService;
    private BridgeGameManager bridgeGameManager;
    private BridgeGame bridgeGame;
    private UserBridge userBridge;

    public BridgeGameService(BridgeMakerService bridgeMakerService, BridgeGameManager bridgeGameManager,
                             BridgeGame bridgeGame, UserBridge userBridge) {
        this.bridgeMakerService = bridgeMakerService;
        this.bridgeGameManager = bridgeGameManager;
        this.bridgeGame = bridgeGame;
        this.userBridge = userBridge;
    }

    private static Direction findDirection(List<String> bridge, BridgeGameManager bridgeGameManager) {
        String now = bridge.get(bridgeGameManager.getStep());
        return Direction.from(now);
    }

    public UserBridge move(String moving) {
        Direction direction = findDirection(bridgeMakerService.getBridge(), bridgeGameManager);
        Direction now = Direction.valueOf(moving);
        bridgeGame.move(userBridge, direction, now);
        return userBridge;
    }

    public boolean fail(String moving) {
        Direction direction = findDirection(bridgeMakerService.getBridge(), bridgeGameManager);
        Direction now = Direction.valueOf(moving);

        if (!direction.equals(now)) {
            bridgeGameManager.gameFail();
            return true;
        }
        return false;
    }

    public boolean play() {
        return userBridge.size() < bridgeMakerService.getBridgeSize();
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
}
