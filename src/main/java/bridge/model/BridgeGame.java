package bridge.model;

import bridge.model.BridgeMaker;
import bridge. BridgeRandomNumberGenerator;
import static bridge.enums.Constant_BridgeGame.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private Map<String, List<String>> progress = new HashMap<>();

    public BridgeGame(int size) {
        retry();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        progress.put(UP_SIDE_PROGRESS.get(), new ArrayList<>());
        progress.put(DOWN_SIDE_PROGESS.get(), new ArrayList<>());
    }
}
