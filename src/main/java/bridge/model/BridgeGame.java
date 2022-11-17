package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private CurrentBridge currentBridge = new CurrentBridge();

    public List<List<String>> move(String bridgeStage, String userMoving) {
        return currentBridge.saveMap(Stage.judge(bridgeStage, userMoving));
    }


    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            currentBridge.clearMap();
            return true;
        }
        if (gameCommand.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException();//예외 확인
    }
}
