package bridge.ui.Input.Exceptions;

import bridge.ui.Input.Repetitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameCommand extends Repetitor {

    private static final List<String> CORRECT_GAME_COMMAND = new ArrayList<>(Arrays.asList("R", "Q"));
    private static final String ERROR_MESSAGE = "[ERROR] 대문자 'R' 혹은 'Q' 만 입력 가능합니다";

    @Override
    protected String checkInputException(String input) throws IllegalArgumentException {
        boolean correctCommand = CORRECT_GAME_COMMAND.contains(input);
        if (!correctCommand) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return input;
    }
}
