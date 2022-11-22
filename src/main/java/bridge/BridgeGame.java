package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<String> upBridgeUserAnswerTable;
    private final List<String> downBridgeUserAnswerTable;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upBridgeUserAnswerTable = new ArrayList<>();
        this.downBridgeUserAnswerTable = new ArrayList<>();
        this.tryCount = 1;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getUpBridgeUserAnswerTable() {
        return upBridgeUserAnswerTable;
    }

    public List<String> getDownBridgeUserAnswerTable() {
        return downBridgeUserAnswerTable;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userChoice) {
        boolean correct = true;
        if (userChoice.equals("U")) {
            correct = upBridgeSetting(userChoice);
        }
        if (userChoice.equals("D")) {
            correct = downBridgeSetting(userChoice);
        }
        return correct;
    }

    private boolean upBridgeSetting(String userChoice) {
        String correctAnswer = bridge.get(upBridgeUserAnswerTable.size());
        downBridgeUserAnswerTable.add(" ");
        upBridgeUserAnswerTable.add("X");
        if (correctAnswer.equals(userChoice)) {
            int curLocation = upBridgeUserAnswerTable.size() - 1;
            upBridgeUserAnswerTable.set(curLocation, "O");
            return true;
        }
        return false;
    }

    private boolean downBridgeSetting(String userChoice) {
        String correctAnswer = bridge.get(downBridgeUserAnswerTable.size());
        upBridgeUserAnswerTable.add(" ");
        downBridgeUserAnswerTable.add("X");
        if (correctAnswer.equals(userChoice)) {
            int curLocation = downBridgeUserAnswerTable.size() - 1;
            downBridgeUserAnswerTable.set(curLocation, "O");
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upBridgeUserAnswerTable.clear();
        downBridgeUserAnswerTable.clear();
        tryCount++;
    }
}
