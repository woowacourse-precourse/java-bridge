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
        int idx = gameProgress.get(0).size();
        if (bridge.get(idx).equals(input)) {
            return replace(input, gameProgress);
        }
        return gameProgress;
    }

    private List<List<String>> replace(String input, List<List<String>> gameProgress) {
        if (input.equals("U")) {
            replaceUp(gameProgress);
        }
        if (input.equals("D")) {
            replaceDown(gameProgress);
        }
        return gameProgress;
    }

    private void replaceUp(List<List<String>> gameProgress) {
        gameProgress.get(0).add("O");
        gameProgress.get(1).add(" ");
    }

    private void replaceDown(List<List<String>> gameProgress) {
        gameProgress.get(0).add(" ");
        gameProgress.get(1).add("O");
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
