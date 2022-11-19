package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int NUMBER_OF_BRIDGE = 2;
    private final List<String> bridge;
    private int currentStage = 0;
    private int tryNumber = 0;
    private boolean isFail = false;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tryNumber++;
    }

    public boolean isFail() {
        return isFail;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        if (bridge.get(currentStage).equals(input)) {
            currentStage++;
            return true;
        }
        isFail = true;
        return false;
    }

    public boolean isGameEnd() {
        return bridge.size() == currentStage;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String restart) {
        if (restart.equals("R")) {
            currentStage = 0;
            isFail = false;
            tryNumber++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
            str += "[ ";
            for (int idx = 0; idx < currentStage; idx++) {
                str = addOorSpace(str, bridgeStatus, idx);
                str = checkLast(str, idx);
            }
            if (isFail) {
                str = addXorSpace(str, bridgeStatus);
            }
            str += "]\n";
        }
        return str;
    }

    private String addXorSpace(String str, BridgeStatus bridgeStatus) {
        if (!bridge.get(currentStage).equals(bridgeStatus.getName())) {
            str += "X ";
            return str;
        }
        str += "  ";
        return str;
    }

    private String checkLast(String str, int idx) {
        if (idx != currentStage - 1 || isFail) {
            str += "| ";
        }
        return str;
    }

    private String addOorSpace(String str, BridgeStatus bridgeStatus, int idx) {
        if (bridge.get(idx).equals(bridgeStatus.getName())) {
            str += "O ";
            return str;
        }
        str += "  ";
        return str;
    }
}
