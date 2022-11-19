package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private Player player;

    public BridgeGame() {

    }

    public void newBridge(int bridgeLength) {
        this.bridge = new Bridge(bridgeLength);
    }

    public void move(String nextStep) {
        Plate nextPlate = Plate.findBySymbol(nextStep);
        player.nextStep(nextPlate);
    }

    public void retry() {
        player.newTry();
    }

    public boolean isSuccess() {
        int currentIndex = player.getPlayerPosition();
        Plate currentPlate = player.getCurrentPlate();
        return bridge.possibleNextStep(currentIndex, currentPlate);
    }
}
