package bridge;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public void validIsNum(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    public void validRange(String userInput) {
        int userInputToInt = Integer.parseInt(userInput);

        if (userInputToInt > 20 || userInputToInt < 3) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_IN_RANGE.getMessage());
        }
    }

    public void validMovingInput(String userInput) {
        if (!(userInput.equals("U") || userInput.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_PERMIT_MOVING_INPUT.getMessage());
        }
    }

    public void validGameCommandInput(String userInput) {
        if (!(userInput.equals("R") || userInput.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_PERMIT_GAME_COMMAND.getMessage());
        }
    }
}
