package bridge.view;

import bridge.utils.command.GameCommand;
import bridge.utils.command.MoveCommand;
import bridge.utils.status.BridgeStatus;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bridge.utils.message.ErrorMessage.*;
import static bridge.utils.message.GameMessage.*;

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
        try {
            validateBridgeSize(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
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
        try {
            validateMoving(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
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
        try {
            validateGameCommand(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }

        return input;
    }

    private void validateGameCommand(String input) {
        if (!GameCommand.contains(input)) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND.getMessage());
        }
    }
}
