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
        if (userInput == NumberToShape.UP.getShape()) {
            return getMoveUPStatus(position, userInput);
        }
        return getMoveDownStatus(position, userInput);
    }

    public String getMoveUPStatus(int position, String userInput) {
        if (userInput == bridgeShape.get(position)) {
            return moveStatus.UP_CORRECT.get();
        }
        return moveStatus.UP_INCORRECT.get();
    }

    public String getMoveDownStatus(int position, String userInput) {
        if (userInput == bridgeShape.get(position)) {
            return moveStatus.DOWN_CORRECT.get();
        }
        return moveStatus.DOWN_INCORRECT.get();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if (userInput == Retry.QUIT.get()) {
            return false;
        }
        return true;
    }
}

enum moveStatus {
    UP_CORRECT("UC"),
    UP_INCORRECT("UIn"),
    DOWN_CORRECT("DC"),
    DOWN_INCORRECT("DIn");

    private String status;

    moveStatus(String status) {
        this.status = status;
    }

    public String get() {
        return status;
    }
}

enum Retry {
    RETRY("R"),
    QUIT("Q");

    private String condition;

    Retry(String condition) {
        this.condition = condition;
    }

    public String get() {
        return condition;
    }
}