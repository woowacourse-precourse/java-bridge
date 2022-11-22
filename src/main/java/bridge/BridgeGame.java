package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private List<String> bridge = new ArrayList<>();
    private int cursor;

    BridgeGame(int size) {
        bridge = bridgeMaker.makeBridge(size);
        cursor = 0;
    }

    // Compare input direction and cursor direction
    public boolean canMove(String direction) {
        if (bridge.get(cursor) == direction) {
            return true;
        }
        return false;
    }


    // can move? cursor +1, if not? cursor -1
    public void move() {
        cursor += 1;
    }

    // Make cursor to zero
    public void retry() {
        cursor = 0;
    }

    // check game is over
    public boolean isOver() {
        return cursor == bridge.size();
    }
}
