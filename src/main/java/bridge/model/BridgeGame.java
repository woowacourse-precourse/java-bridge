package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private CurrentBridge currentBridge = new CurrentBridge();

    public String move(String userMoving, String bridgeStage) {
        return currentBridge.saveMap(Stage.judge(userMoving, bridgeStage));
    }

    public void retry() {
        currentBridge.clearMap();
    }
}
