package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    enum Command {
        UP("U"),
        DOWN("D"),
        RETRY("R"),
        QUIT("Q");

        private String data;

        Command(String data) {
            this.data = data;
        }
    }

    enum Move {
        UP_CORRECT("UC"),
        UP_INCORRECT("UI"),
        DOWN_CORRECT("DC"),
        DOWN_INCORRECT("DI");

        private String status;

        Move(String status) {
            this.status = status;
        }

        public String get() {
            return status;
        }
    }

    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(int position, String userInput) {
        if (userInput.equals(Command.UP.data)) {
            return getMoveUPStatus(position, userInput);
        }
        return getMoveDownStatus(position, userInput);
    }

    public String getMoveUPStatus(int position, String userInput) {
        if (userInput.equals(bridge.get(position))) {
            return Move.UP_CORRECT.status;
        }
        return Move.UP_INCORRECT.status;
    }

    public String getMoveDownStatus(int position, String userInput) {
        if (userInput.equals(bridge.get(position))) {
            return Move.DOWN_CORRECT.status;
        }
        return Move.DOWN_INCORRECT.status;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if (userInput.equals(Command.QUIT.data)) {
            return false;
        }
        return true;
    }
}
