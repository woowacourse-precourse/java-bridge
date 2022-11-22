package bridge.model;

import bridge.util.Rules;

import java.util.List;

public class BridgeGame {
    private Bridge bridge;
    private PlayerPath playerPath;
    private TryCount tryCount;

    public BridgeGame() {
        playerPath = new PlayerPath();
        tryCount = new TryCount();
    }

    public void newBridge(int bridgeLength) {
        bridge = new Bridge(bridgeLength);
    }

    public void move(String nextStep) {
        Plate nextPlate = Plate.findBySymbol(nextStep);
        playerPath.nextStep(nextPlate);
    }

    public boolean retry(String inputRetry) {
        if (inputRetry.equals(Rules.GAME_RETRY)) {
            playerPath = new PlayerPath();
            tryCount.retry();
            return true;
        }
        return false;
    }

    public boolean isSuccessCrossingBridge() {
        List<Plate> playerPath = this.playerPath.getPlayerPath();
        return bridge.sameAs(playerPath);
    }

    public boolean isSuccessNextStep() {
        int currentIndex = playerPath.currentPosition();
        Plate currentPlate = playerPath.currentPlate();
        return bridge.possibleNextStep(currentIndex, currentPlate);
    }

    public int getTryCount() {
        return tryCount.getTryCount();
    }

    public List<Plate> getPlayerPath() {
        return playerPath.getPlayerPath();
    }
}
