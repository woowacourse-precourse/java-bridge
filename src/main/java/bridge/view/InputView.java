package bridge.view;

import bridge.utils.BridgeStatus;
import bridge.utils.GameCommand;
import bridge.utils.MoveCommand;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bridge.utils.ErrorMessage.*;
import static bridge.utils.GameMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String REGEX_NOT_NUMBER = "\\D";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }

        int parsedInput = Integer.parseInt(input);
        if (BridgeStatus.isOutOfRange(parsedInput)) {
            throw new IllegalArgumentException(BRIDGE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isNotNumber(String input) {
        Pattern pattern = Pattern.compile(REGEX_NOT_NUMBER);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_COMMAND);
        String input = Console.readLine();
        validateMoving(input);
        return input;
    }

    private void validateMoving(String input) {
        if (!MoveCommand.contains(input)) {
            throw new IllegalArgumentException(INVALID_MOVING_COMMAND.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }

    private void validateGameCommand(String input) {
        if (!GameCommand.contains(input)) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND.getMessage());
        }
    }
}
