package bridge.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int tryCount;
    private int currentIndex;
    private List<String> bridge;
    private List<String>[] result;

    public BridgeGame(List<String> bridge) {
        this.tryCount = 0;
        this.currentIndex = 0;
        this.bridge = bridge;
        this.result = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            result[i] = new ArrayList<>();
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        int index = convertToIndex(direction);
        String answer = calculateAnswer(currentIndex, direction);
        result[index].add(answer);
        result[(index + 1) % 2].add(" ");
        currentIndex++;
        if (answer.equals("X")) {
            return false;
        }
        return true;
    }
    private int convertToIndex(String direction) {
        if (direction.equals("U")) {
            return 0;
        }
        return 1;
    }
    private String calculateAnswer(int tryCount, String direction) {
        if (bridge.get(tryCount).equals(direction)) {
            return "O";
        }
        return "X";
    }
    public List<String>[] getResult() {
        return result;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
    public boolean isEnd() {
        if (bridge.size() == tryCount) {
            return true;
        }
        return false;
    }
}
