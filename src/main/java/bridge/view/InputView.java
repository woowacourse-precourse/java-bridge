package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

import static bridge.view.InputViewConstants.*;

public class InputView {

    public static int readBridgeSize() {
        System.out.println(GET_BRIDGE_SIZE_MESSAGE);
        String input = Console.readLine();
        try {
            validateNumberForm(input);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    private static void validateNumberForm(String input) {
        validateBlank(input);
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(String.format(NUMBER_FORMAT_ERROR_MESSAGE, input));
        }
    }

    public static String readMoving() {
        System.out.println(GET_PLAYER_MOVE_MESSAGE);
        String input = Console.readLine();
        try {
            validate(input, UP_STAIR, DOWN_STAIR);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readMoving();
        }
        return input;
    }

    public static boolean readGameCommand() {
        System.out.println(GET_GAME_COMMAND_MESSAGE);
        String input = Console.readLine();
        try {
            validate(input, GAME_REPLAY, GAME_QUIT);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readGameCommand();
        }
        return input.equals(GAME_REPLAY);
    }

    private static void validate(String input, String option, String otherOption) {
        validateBlank(input);
        validateStringForm(input);
        validateOption(input, option, otherOption);
    }

    private static void validateStringForm(String input) {
        if (!Pattern.matches(STRING_REGEX, input)) {
            throw new IllegalArgumentException(String.format(STRING_FORMAT_ERROR_MESSAGE, input));
        }
    }

    private static void validateOption(String input, String option, String otherOption) {
        if (!input.equals(option) && !input.equals(otherOption)) {
            throw new IllegalArgumentException(
                String.format(FORMAT_OPTION_ERROR_MESSAGE, option, otherOption));
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

}