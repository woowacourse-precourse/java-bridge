package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int retrialNumber = 1;
    private int bridgeIndex = 0;
    private int bridgeSize = 0;

    private boolean gameSuccess = true;
    private List<String> userBridge = new ArrayList<>();
    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeSize = bridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userBridgeType) {
        userBridge.add(userBridgeType);
        String currentBridgeType = bridge.get(bridgeIndex);
        if (userBridgeType.equals(currentBridgeType)) {
            bridgeIndex++;
            return true;
        }
        addFailFlag(userBridgeType);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void addFailFlag(String userBridgeType) {
        String failFlag = "F";

        userBridge.remove(userBridge.size()-1);
        userBridge.add(userBridgeType+failFlag);
    }

    public void retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            retrialNumber++;
            userBridge.clear();
            bridgeIndex = 0;
        }
    }

    public boolean succeed() {
        boolean bridgeCompleteCondition = (bridgeIndex < bridgeSize);
        boolean quitCondition = (gameSuccess == true);
        return (bridgeCompleteCondition && quitCondition);
    }


    public List<String> getUserBridge() {
        return userBridge;
    }
    public int getRetrialNumber() {
        return retrialNumber;
    }

    public boolean getGameSuccess() {
        return gameSuccess;
    }

    public void setGameSuccess(String gameCommand) {
        if (gameCommand.equals("Q")) {
            gameSuccess = false;
        }
    }
}
