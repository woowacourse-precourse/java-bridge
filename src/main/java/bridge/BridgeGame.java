package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<List<String>> bridgeMap;
    private List<String> upBridge;
    private List<String> downBridge;

    private int position;
    private int retryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeMap = new ArrayList<>();
        bridgeMapGenerate();
        this.position = 0;
        this.retryCount = 1;
    }

    private void bridgeMapGenerate() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        bridgeMap.add(upBridge);
        bridgeMap.add(downBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direct) {
        if (isMove(direct)) {
            position += 1;
            return true;
        }
        return false;
    }

    private boolean isMove(String direct) {
        return bridge.get(position).equals(direct);
    }

    public boolean isEndBridge() {
        return bridge.size() == position;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        retryCount += 1;
    }
}
