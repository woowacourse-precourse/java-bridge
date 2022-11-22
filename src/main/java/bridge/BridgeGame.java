package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final int UPWARD = 1;
    public static final int DOWNWARD = 0;
    private final List<String> bridge;
    private final List<List<String>> userInputBridge;
    private int tryCount = 1;
    private int current;

    public BridgeGame(int bridgeSize) {
        userInputBridge = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            userInputBridge.add(new ArrayList<>());
        }
        current = 0;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String moving) {
        if (bridge.get(current).equals(moving)) {
            moveCorrect(moving);
        }
        if (!bridge.get(current).equals(moving)) {
            moveWrong(moving);
        }
        current++;
        return userInputBridge;
    }

    private void moveWrong(String moving) {
        if (moving.equals("U")) {
            userInputBridge.get(UPWARD).add("X");
            userInputBridge.get(DOWNWARD).add(" ");
        }
        if (moving.equals("D")) {
            userInputBridge.get(UPWARD).add(" ");
            userInputBridge.get(DOWNWARD).add("X");
        }
    }

    private void moveCorrect(String moving) {
        if (moving.equals("U")) {
            userInputBridge.get(UPWARD).add("O");
            userInputBridge.get(DOWNWARD).add(" ");
        }
        if (moving.equals("D")) {
            userInputBridge.get(UPWARD).add(" ");
            userInputBridge.get(DOWNWARD).add("O");
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        for (int i = 0; i < 2; i++) {
            userInputBridge.get(i).clear();
        }
        tryCount++;
        current = 0;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<List<String>> getUserInputBridge() {
        return userInputBridge;
    }
}
