package bridge.ui.Input.Exceptions;

import bridge.Commands;
import bridge.ui.Input.Repetitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Moving extends Repetitor {

    private static final List<String> CORRECT_MOVING_CASE =
            new ArrayList(Arrays.asList(Commands.DOWN.getCommand(), Commands.UP.getCommand()));
    private static final String ERROR_MESSAGE =
            "[ERROR] 대문자 '" + Commands.DOWN.getCommand() + "' 혹은 '" + Commands.UP.getCommand() + "' 만 입력 가능합니다";

    @Override
    protected String checkInputException(String input) throws IllegalArgumentException {
        boolean correctCase = CORRECT_MOVING_CASE.contains(input);
        if (!correctCase) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return input;
    }
}
