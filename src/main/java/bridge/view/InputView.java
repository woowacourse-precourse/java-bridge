package bridge.view;

import static bridge.core.Bridge.UP_BLOCK_MARK;
import static bridge.core.Bridge.DOWN_BLOCK_MARK;
import static bridge.ErrorMessage.INVALID_BRIDGE_SIZE_ERROR;
import static bridge.ErrorMessage.INVALID_MOVE_DIRECTION_ERROR;
import static bridge.core.GameCommand.getEnum;

import bridge.core.GameCommand;
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
        String moveDirectionInput = readLine();
        validateMoveDirection(moveDirectionInput);
        return moveDirectionInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand(Runnable printInputMessage) {
        printInputMessage.run();
        return getEnum(readLine());
    }

    public void validateBridgeSize(String bridgeSizeInput) {
        final String IN_3_TO_20_PATTERN = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";

        if (!bridgeSizeInput.matches(IN_3_TO_20_PATTERN)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_ERROR);
        }
    }

    public void validateMoveDirection(String moveDirectionInput) {
        final List<String> validMoveDirections = List.of(UP_BLOCK_MARK, DOWN_BLOCK_MARK);

        if (!validMoveDirections.contains(moveDirectionInput)) {
            throw new IllegalArgumentException(INVALID_MOVE_DIRECTION_ERROR);
        }
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
