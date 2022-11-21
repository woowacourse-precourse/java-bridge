package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    String bridgeGameUpResult = "[";
    String bridgeGameDownResult = "[";

    public String getBridgeGameUpResult() {
        return bridgeGameUpResult.substring(0, bridgeGameUpResult.length() - 1);
    }

    public String getBridgeGameDownResult() {
        return bridgeGameDownResult.substring(0, bridgeGameDownResult.length() - 1);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridge, String moving, int bridgeIndex) {
        String movingResult = " X ";

        if (bridge.get(bridgeIndex).equals(moving)) {
            movingResult = " O ";
        }

        setBridgeGameResult(movingResult, moving);

        return movingResult;
    }

    private void setBridgeGameResult(String movingResult, String moving) {
        if (moving.equals("U")) {
            bridgeGameUpResult += movingResult + "|";
            bridgeGameDownResult += "   |";
        }

        if (moving.equals("D")) {
            bridgeGameUpResult += "   |";
            bridgeGameDownResult += movingResult + "|";
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeGameUpResult = "[";
        bridgeGameDownResult = "[";
    }
}
