package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int UP_WARD = 0;
    private static final int DOWN_WARD = 1;
    private List<String> bridge;
    private List<List<String>> userInputBridge;
    int index;

    public BridgeGame(int bridgeSize) {
        userInputBridge = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            userInputBridge.add(new ArrayList<>());
        }
        index = 0;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String moving) {
        if (bridge.get(index).equals(moving)) {
            moveCorrect(moving);
        }
        if (!bridge.get(index).equals(moving)) {
            moveWrong(moving);
        }
        return userInputBridge;
    }

    private void moveWrong(String moving) {
        if (moving.equals("U")) {
            userInputBridge.get(UP_WARD).add("X");
            userInputBridge.get(DOWN_WARD).add(" ");
        }
        if (moving.equals("D")) {
            userInputBridge.get(UP_WARD).add(" ");
            userInputBridge.get(DOWN_WARD).add("X");
        }
    }

    private void moveCorrect(String moving) {
        if (moving.equals("U")) {
            userInputBridge.get(UP_WARD).add("O");
            userInputBridge.get(DOWN_WARD).add(" ");
        }
        if (moving.equals("D")) {
            userInputBridge.get(UP_WARD).add(" ");
            userInputBridge.get(DOWN_WARD).add("O");
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
