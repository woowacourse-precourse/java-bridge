package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    static final int RIGHT_MATCH_DOWN = 0;
    static final int RIGHT_MATCH_UP = 1;
    static final int WRONG_MATCH_DOWN = 2;
    static final int WRONG_MATCH_UP = 3;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(List<String> bridge, int bridgeIndex, String input) {
        if(bridge.get(bridgeIndex).equals(input)) {
            if(input == "U") {
                return RIGHT_MATCH_UP;
            }
            return RIGHT_MATCH_DOWN;
        }

        if (input == "U") {
            return WRONG_MATCH_UP;
        }
        return WRONG_MATCH_DOWN;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
