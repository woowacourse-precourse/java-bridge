package bridge;

import bridge.view.InputView;
import org.assertj.core.api.ThrowableAssert;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

/**
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    private final static InputView inputView = new InputView();
    private final static String ERROR_INVALID_MOVE_COMMAND = "[ERROR] 위: U, 아래: D 로 입력해 주세요.";
    private final static String ERROR_INVALID_GAME_COMMAND = "[ERROR] 재시작: R, 종료: Q 로 입력해 주세요.";
    private final static String MOVE_UP_COMMAND = "U";
    private final static String MOVE_DOWN_COMMAND = "D";
    private final static String RETRY_GAME_COMMAND = "R";
    private final static String END_GAME_COMMAND = "Q";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moveCommand) {
         return moveValidate(moveCommand);
    }

    private String moveValidate(String moveCommand) {
        if (moveCommand.equals(MOVE_UP_COMMAND) || moveCommand.equals(MOVE_DOWN_COMMAND)) {
            return moveCommand;
        }
        throw new IllegalArgumentException(ERROR_INVALID_MOVE_COMMAND);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry(String gameCommand) {
        return retryValidate(gameCommand);
    }

    private String retryValidate(String gameCommand) {
        if (gameCommand.equals(END_GAME_COMMAND) || gameCommand.equals(RETRY_GAME_COMMAND)) {
            return gameCommand;
        }
        throw new IllegalArgumentException(ERROR_INVALID_GAME_COMMAND);
    }
}
