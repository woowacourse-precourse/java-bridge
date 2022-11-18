package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<List<String>> move(String input, List<List<String>> gameProgress) {
        validMoveCommand(input);
        int index = gameProgress.get(0).size();
        if (isCorrectMove(input, index)) {
            return correctMove(input, gameProgress);
        }
        return incorrectMove(bridge.get(index), gameProgress);
    }

    private boolean isCorrectMove(String input, int index) {
        return bridge.get(index).equals(input);
    }

    private List<List<String>> correctMove(String moving, List<List<String>> gameProgress) {
        if (moving.equals("U")) {
            correctMoveUp(gameProgress);
        }
        if (moving.equals("D")) {
            correctMoveDown(gameProgress);
        }
        return gameProgress;
    }

    private void correctMoveUp(List<List<String>> gameProgress) {
        gameProgress.get(0).add("O");
        gameProgress.get(1).add(" ");
    }

    private void correctMoveDown(List<List<String>> gameProgress) {
        gameProgress.get(0).add(" ");
        gameProgress.get(1).add("O");
    }

    private List<List<String>> incorrectMove(String moving, List<List<String>> gameProgress) {
        if (moving.equals("U")) {
            incorrectMoveUp(gameProgress);
        }
        if (moving.equals("D")) {
            incorrectMoveDown(gameProgress);
        }
        return gameProgress;
    }

    private void incorrectMoveUp(List<List<String>> gameProgress) {
        gameProgress.get(0).add("X");
        gameProgress.get(1).add(" ");
    }

    private void incorrectMoveDown(List<List<String>> gameProgress) {
        gameProgress.get(0).add(" ");
        gameProgress.get(1).add("X");
    }

    private void validMoveCommand(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U, D 중 하나를 입력해 주세요.");
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
