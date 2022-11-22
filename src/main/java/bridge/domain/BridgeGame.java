package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.ThrowableAssert;

import java.util.ArrayList;
import java.util.List;

import static bridge.messages.ExceptionMessage.ERROR_INVALID_GAME_COMMAND;
import static bridge.messages.ExceptionMessage.ERROR_INVALID_MOVE_COMMAND;

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
    private final static String MOVE_UP_COMMAND = "U";
    private final static String MOVE_DOWN_COMMAND = "D";
    private final static String RETRY_GAME_COMMAND = "R";
    private final static String END_GAME_COMMAND = "Q";
    private final static String RIGHT_WAY = " O ";
    private final static String WRONG_WAY = " X ";
    private final static String BLACK = "   ";
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();
    private boolean gameResult = true;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveCommand, String bridgeValue) {
        boolean correctAnswer;
        if (moveValidate(moveCommand).equals(bridgeValue)) {
            moveRightWay(moveCommand);
            return correctAnswer = true;
        }
        moveWrongWay(moveCommand);
        gameResult = false;
        return correctAnswer = false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (retryValidate(gameCommand).equals(RETRY_GAME_COMMAND)) {
            return true;
        }
        return false;
    }

    public List<List<String>> getBridges() {
        return List.of(upBridge, downBridge);
    }

    private void moveRightWay(String moveCommand) {
        if (moveCommand.equals(MOVE_UP_COMMAND)) {
            upBridge.add(RIGHT_WAY);
            downBridge.add(BLACK);
            return;
        }
        downBridge.add(RIGHT_WAY);
        upBridge.add(BLACK);
    }

    private void moveWrongWay(String moveCommand) {
        if (moveCommand.equals(MOVE_UP_COMMAND)) {
            upBridge.add(WRONG_WAY);
            downBridge.add(BLACK);
            return;
        }
        downBridge.add(WRONG_WAY);
        upBridge.add(BLACK);
    }

    private String moveValidate(String moveCommand) {
        if (moveCommand.equals(MOVE_UP_COMMAND) || moveCommand.equals(MOVE_DOWN_COMMAND)) {
            return moveCommand;
        }
        throw new IllegalArgumentException(ERROR_INVALID_MOVE_COMMAND.getMessage());
    }

    private String retryValidate(String gameCommand) {
        if (gameCommand.equals(END_GAME_COMMAND) || gameCommand.equals(RETRY_GAME_COMMAND)) {
            return gameCommand;
        }
        throw new IllegalArgumentException(ERROR_INVALID_GAME_COMMAND.getMessage());
    }
}