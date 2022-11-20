package bridge.model;

import java.util.List;

public class BridgeGame {

    private Bridge bridge;
    private Player player;

    public BridgeGame() {
        this.player = new Player();
    }

    public void newBridge(int bridgeLength) {
        this.bridge = new Bridge(bridgeLength);
    }

    public List<Plate> getPlayerPath() {
        return player.getPlayerPath();
    }

    public void move(String nextStep) {
        Plate nextPlate = Plate.findBySymbol(nextStep);
        player.nextStep(nextPlate);
    }

    public void retry() {
        player.newTry();
    }

    public void victory() {
        player.victory();
    }

    public boolean isSuccess() {
        int currentIndex = player.getPlayerPosition();
        Plate currentPlate = player.getCurrentPlate();
        return bridge.possibleNextStep(currentIndex, currentPlate);
    }

    public boolean isEndOfBridge() {
        int currentIndex = player.getPlayerPosition();
        int lastIndex = bridge.getBridgeLastIndex();
        return currentIndex == lastIndex;
    }

    public boolean isVictory() {
        return player.isVictory();
    }

    public int getTryCount() {
        return player.getGameTryCount();
    }
}
