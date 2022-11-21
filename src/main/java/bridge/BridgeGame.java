package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridgeShape;

    public BridgeGame(List<String> bridgeShape) {
        this.bridgeShape = bridgeShape;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(int position, String userInput) {
        if (userInput.equals(NumberToShape.UP.getShape())) {
            return getMoveUPStatus(position, userInput);
        }
        return getMoveDownStatus(position, userInput);
    }

    public String getMoveUPStatus(int position, String userInput) {
        if (userInput.equals(bridgeShape.get(position))) {
            return MoveStatus.UP_CORRECT.get();
        }
        return MoveStatus.UP_INCORRECT.get();
    }

    public String getMoveDownStatus(int position, String userInput) {
        if (userInput.equals(bridgeShape.get(position))) {
            return MoveStatus.DOWN_CORRECT.get();
        }
        return MoveStatus.DOWN_INCORRECT.get();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if (userInput.equals(Command.QUIT.get())) {
            return false;
        }
        return true;
    }
}

enum MoveStatus {
    UP_CORRECT("UpCorrect"),
    UP_INCORRECT("UpIncorrect"),
    DOWN_CORRECT("DownCorrect"),
    DOWN_INCORRECT("DownIncorrect");

    private String status;

    MoveStatus(String status) {
        this.status = status;
    }

    public String get() {
        return status;
    }
}

enum Command {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private String condition;

    Command(String condition) {
        this.condition = condition;
    }

    public String get() {
        return condition;
    }
}