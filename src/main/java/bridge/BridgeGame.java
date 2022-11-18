package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private boolean gameEnd = false;
    private int movingCount = 0;
    private int gameCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (bridge.get(movingCount).equals(moving)) {
            movingCount++;
            return;
        }
        gameEnd = true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isFinishBridge() {
        return bridge.size() == movingCount;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public List<List<String>> resultBridgeMoving() {
        List<List<String>> result = List.of(new ArrayList<>(), new ArrayList<>());

        for (int i = 0; i < gameCount; i++) {
            if (bridge.get(i).equals("U")) {
                result.get(0).add("O");
                result.get(1).add(" ");
                continue;
            }
            result.get(0).add(" ");
            result.get(1).add("O");
        }

        if (gameEnd) {
            if (bridge.get(movingCount).equals("U")) {
                result.get(0).add("X");
                result.get(1).add(" ");
            } else {
                result.get(0).add(" ");
                result.get(1).add("X");
            }
        }

        return result;
    }
}
