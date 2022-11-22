package bridge;

import bridge.constant.enumtype.BridgeGameRule;
import bridge.constant.enumtype.UIMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> resultBridge = new ArrayList<>();
    private static Integer bridgeMovingCount = 0;

    public static Integer getBridgeGamePlayCount() {
        return bridgeGamePlayCount;
    }

    private static Integer bridgeGamePlayCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public List<String> move(List<String> bridge, String movingCharacter) {
        ++bridgeMovingCount;
        String cellPassedCharacter = "X";
        if (bridge.get(bridgeMovingCount - 1).equals(movingCharacter)) {
            cellPassedCharacter = "O";
        }
        resultBridge.add(cellPassedCharacter);
        return resultBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry(String retryCharacter) {
        if (retryCharacter.equals(BridgeGameRule.RETRY.getValue())) {
            this.resultBridge.clear();
            bridgeMovingCount = 0;
            ++bridgeGamePlayCount;
            return true;
        }
        return false;
    }
}
