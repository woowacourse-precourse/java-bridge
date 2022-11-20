package bridge;

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
    private static final long MIN_BRIDGE_SIZE = 3;
    private static final long MAX_BRIDGE_SIZE = 20;
    private static final String MOVING_COMMAND_UP = "U";
    private static final String MOVING_COMMAND_DOWN = "D";
    private static final String RESTART_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";


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

        if (isOutOfRange(input)) {
            throw new IllegalArgumentException(BRIDGE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(String input) {
        long size = Long.parseLong(input);
        return (size < MIN_BRIDGE_SIZE) || (size > MAX_BRIDGE_SIZE);
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
        if (isNotMovingCommand(input)) {
            throw new IllegalArgumentException(INVALID_MOVING_COMMAND.getMessage());
        }
    }

    private boolean isNotMovingCommand(String input) {
        return !MOVING_COMMAND_UP.equals(input) && !MOVING_COMMAND_DOWN.equals(input);
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
        if (isNotGameCommand(input)) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND.getMessage());
        }
    }

    private boolean isNotGameCommand(String input) {
        return !RESTART_COMMAND.equals(input) && !QUIT_COMMAND.equals(input);
    }
}
