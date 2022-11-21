package bridge;

import bridge.util.CommandKeys;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 1. BridgeGame에 필드(인스턴스 변수)를 추가할 수 🌴있다.🌴
 * 2. BridgeGame의 패키지는 변경할 수 🌴있다.🌴
 * 3. BridgeGame의 메서드의 이름은 변경할 수 🌴없고🌴, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 🌴있다.🌴
 * 4. 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 🌴있다.🌴
 * 5. BridgeGame 클래스에서 InputView, OutputView 클래스를 사용하지 않는다.
 */
public class BridgeGame {
    private static final String CORRECT_MOVING = "O";
    private static final String WRONG_MOVING = "X";

    private final List<String> answerBridge;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String currentMoving, int index) {
        final String answerMoving = answerBridge.get(index);
        if (answerMoving.equals(currentMoving)) {
            return CORRECT_MOVING;
        }
        return WRONG_MOVING;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(int trialCount) {
        return trialCount + 1;
    }

    public boolean isMovingUp(String currentMoving) {
        return CommandKeys.isSame(CommandKeys.UP, currentMoving);
    }

    public boolean isMovingDown(String currentMoving) {
        return CommandKeys.isSame(CommandKeys.DOWN, currentMoving);
    }

    public void updateOneSideResults(List<String> oneSideResults, String moveResult) {
        oneSideResults.add(moveResult);
    }
}
