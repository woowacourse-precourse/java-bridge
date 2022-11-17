package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int index = 0;

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    //사용자가 칸을 이동할 때 사용하는 메서드
    public boolean move(String inputPosition) {
        if (inputPosition.equals(bridge.get(index))) {
            index++;
            return true;
        }
        return false;
    }

    //사용자가 게임을 다시 시도할 때 사용하는 메서드
    public void retry() {
        index = 0;
    }

    public int getIndex() {
        return index;
    }
}
