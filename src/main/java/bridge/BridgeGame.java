package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private String box = "[]";
    List<String> upBridge = new ArrayList<>(List.of(box.split("")));
    List<String> downBridge = new ArrayList<>(List.of(box.split("")));


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String move, List<String> bridgeMaker, int i) {
        if (move.contentEquals(bridgeMaker.get(i - 1)) && move.contains("U")) {
            upBridge.add(2 * i - 1, " O ");
        }
        if (!move.contentEquals(bridgeMaker.get(i - 1)) && move.contains("U")) {
            upBridge.add(2 * i - 1, " X ");
        }
        if (move.contains("D")) {
            upBridge.add(2 * i - 1, "   ");
        }
        return upBridge;
    }

    public List<String> downMove(String move, List<String> bridgeMaker, int i) {
        if (move.contentEquals(bridgeMaker.get(i - 1)) && move.contains("D")) {
            downBridge.add(2 * i - 1, " O ");
        }
        if (!move.contentEquals(bridgeMaker.get(i - 1)) && move.contains("D")) {
            downBridge.add(2 * i - 1, " X ");
        }
        if (move.contains("U")) {
            downBridge.add(2 * i - 1, "   ");
        }
        return downBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Integer retry(int count) {
        count++;
        return count;
    }
}
