package bridge;

import static bridge.Bridge.*;
import static bridge.Controller.*;
import static bridge.ErrorMessage.INVALID_BRIDGE_SIZE_ERROR;
import static bridge.ErrorMessage.INVALID_GAME_COMMAND_ERROR;
import static bridge.ErrorMessage.INVALID_MOVE_DIRECTION_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(Runnable printInputMessage) {
        printInputMessage.run();
        String bridgeSizeInput = readLine();
        validateBridgeSize(bridgeSizeInput);
        return Integer.valueOf(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(Runnable printInputMessage) {
        printInputMessage.run();
        String moveDirection = readLine();
        validateMoveDirection(moveDirection);
        return moveDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(Runnable printInputMessage) {
        printInputMessage.run();
        String gameCommand = readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    public void validateBridgeSize(String bridgeSizeInput) {
        final String IN_3_TO_20_PATTERN = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";

        if (!bridgeSizeInput.matches(IN_3_TO_20_PATTERN)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_ERROR);
        }
    }

    public void validateGameCommand(String gameCommand) {
        final List<String> validGameCommands = List.of(RETRY_GAME_COMMAND, QUIT_GAME_COMMAND);

        if (!validGameCommands.contains(gameCommand)) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR);
        }
    }

    public void validateMoveDirection(String moveDirection) {
        final List<String> validMoveDirections = List.of(UP_BLOCK_MARK, DOWN_BLOCK_MARK);

        if (!validMoveDirections.contains(moveDirection)) {
            throw new IllegalArgumentException(INVALID_MOVE_DIRECTION_ERROR);
        }
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
