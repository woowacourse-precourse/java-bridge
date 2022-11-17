package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private userStages userStages = new userStages();

    public void move(String userMoving, String bridgeStage) {
        userStages.savePosition(Stage.judge(userMoving, bridgeStage));
    }

    public void retry() {
        userStages.init();
    }
}
