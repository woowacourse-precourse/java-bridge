package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int trialNumber = 1;
    private boolean gameSuccess = true;
    private List<String> userBridge = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userBridgeType) {
        int bridgeIndex = userBridge.size();
        String correctBridgeType = bridge.get(bridgeIndex);
        if (userBridgeType.equals(correctBridgeType)) {
            userBridge.add(userBridgeType);
            return true;
        }
        addFailFlag(userBridgeType);
        return false;
    }

    private void addFailFlag(String userBridgeType) {
        final String failFlag = "F";
        userBridge.add(userBridgeType + failFlag);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void retry() {
        trialNumber++;
        userBridge.clear();
    }

    public boolean isNotOver() {
        boolean bridgeCompleteCondition = (userBridge.size() < bridge.size());
        boolean quitCondition = (gameSuccess == true);
        return (bridgeCompleteCondition && quitCondition);
    }


    public List<String> getUserBridge() {
        return userBridge;
    }

    public int getRetrialNumber() {
        return trialNumber;
    }

    public boolean getGameSuccess() {
        return gameSuccess;
    }

    public void giveUp() {
        gameSuccess = false;
    }
}
