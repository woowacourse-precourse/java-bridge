package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static int move(List<String> bridge, int indexOfBridge, String move) {
        if(Objects.equals(bridge.get(indexOfBridge), move)){
            return correctMoving(move);
        }
        return incorrectMoving(move);
    }

    /** 0 -> down 성공, 1 -> down 실패, 2 -> up 성공, 3 -> up 실패 **/
    private static int correctMoving(String move) {
        Map<String, Object> movingChecker = new HashMap<>();
        movingChecker.put("U", 2);
        movingChecker.put("D", 0);
        return (int) movingChecker.get(move);
    }

    private static int incorrectMoving(String move) {
        Map<String, Object> movingChecker = new HashMap<>();
        movingChecker.put("U", 3);
        movingChecker.put("D", 1);
        return (int) movingChecker.get(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(boolean presentResult) {
        return !presentResult;
    }
}
