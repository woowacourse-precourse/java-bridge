package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int tryCount  = 1;
    private List<String> bridge;
    private List<String> inputBridge = new ArrayList<>();

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException(Error.NOT_MOVE_INPUT.label());
        }
        inputBridge.add(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        inputBridge.clear();
        tryCount++;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getInputBridge() {
        return inputBridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSuccess() {
        return bridge.equals(inputBridge);
    }

    public boolean isRightStep() {
        for (int i = 0; i < inputBridge.size(); i++) {
            if (!inputBridge.get(i).equals(bridge.get(i))) {
                return false;
            }
        }
        return true;
    }
}
