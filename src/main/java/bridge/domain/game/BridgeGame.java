package bridge.domain.game;

import bridge.domain.bridge.Bridge;

public class BridgeGame {
    Bridge realBridge;
    BridgeGameResult bridgeGameResult;
    private int userLocation;
    private int gameRoundCount;

    public BridgeGame(Bridge bridge) {
        this.initSettings();
        this.gameRoundCount = 1;
        this.realBridge = bridge;
    }

    public boolean isUserCanMove() {
        return realBridge.canMove(userLocation);
    }

    public int getGameRoundCount() {
        return gameRoundCount;
    }

    public BridgeGameResult getGameResult() {
        return bridgeGameResult;
    }

    private void initSettings() {
        this.userLocation = -1;
        this.bridgeGameResult = new BridgeGameResult();
    }

    public boolean move(String userMoving) {
        userLocation++;
        boolean correct = realBridge.isCorrect(userLocation, userMoving);

        bridgeGameResult.update(userMoving, correct);
        return correct;
    }

    public void retry() {
        initSettings();
        gameRoundCount++;
    }
}
