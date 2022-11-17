package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private userStage userStage = new userStage();

    public void move(String userMoving, String bridgeStage) {
        userStage.savePosition(Stage.judge(userMoving, bridgeStage));
    }

    public void retry() {
        userStage.init();
    }

    public boolean isNotReached(int bridgeSize) {
        if (userStage.getSize() == bridgeSize) {
            userStage.updateSuccess();
            return false;
        }
        return true;
    }
}
