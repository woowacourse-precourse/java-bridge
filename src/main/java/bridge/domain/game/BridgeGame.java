package bridge.domain.game;

import bridge.domain.bridge.Bridge;

import static bridge.util.Constants.ROUND_COUNT_INIT_VALUE;
import static bridge.util.Constants.USER_LOCATION_INIT_VALUE;

public class BridgeGame {
    Bridge realBridge;
    BridgeGameResult bridgeGameResult;
    private int userLocation;
    private int gameRoundCount;

    public BridgeGame(Bridge bridge) {
        this.initSettings();
        this.gameRoundCount = ROUND_COUNT_INIT_VALUE;
        this.realBridge = bridge;
    }

    private void initSettings() {
        this.userLocation = USER_LOCATION_INIT_VALUE;
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

    public boolean isUserCanMove() {
        return realBridge.canMove(userLocation);
    }

    public int getGameRoundCount() {
        return gameRoundCount;
    }

    public BridgeGameResult getGameResult() {
        return bridgeGameResult;
    }
}
