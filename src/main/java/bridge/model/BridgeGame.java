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
        Tile nextTile = Tile.findBySymbol(nextStep);
        playerPath.nextStep(nextTile);
    }

    public boolean retry(String inputRetry) {
        if (inputRetry.equals(Rules.GAME_RETRY)) {
            playerPath = new PlayerPath();
            tryCount.retry();
            return true;
        }
        return false;
    }

    public PlayerStatus checkPlayerStatus() {
        List<Tile> playerPath = this.playerPath.getPlayerPath();
        boolean isSuccess = bridge.sameAs(playerPath);
        return PlayerStatus.findBySurvive(isSuccess);
    }

    public boolean possibleNextStep() {
        int currentIndex = playerPath.currentPosition();
        Tile currentTile = playerPath.currentTile();
        return bridge.possibleNextStep(currentIndex, currentTile);
    }

    public int getTryCount() {
        return tryCount.getTryCount();
    }

    public List<Tile> getPlayerPath() {
        return playerPath.getPlayerPath();
    }
}
