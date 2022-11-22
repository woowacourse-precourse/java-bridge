package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

import static bridge.Controller.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final List<String> bridge;
    private int tryCount;

    public BridgeGame(int size) {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
        this.tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String pos, int bridgeIndex) {
        if (bridge.get(bridgeIndex).equals(pos)) {
            if (bridgeIndex == bridge.size() - 1) {
                return GAME_FINISH;
            }
            return GAME_SUCCESS;
        }
        return GAME_FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals("R")) {
            tryCount++;
            return true;
        }
        return false;
    }

    public int getTryCount() {
        return tryCount;
    }
}
