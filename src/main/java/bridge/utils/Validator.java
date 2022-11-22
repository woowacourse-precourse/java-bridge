package bridge.utils;

import bridge.constants.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public int isInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INT.getDescription());
        }
        return Integer.parseInt(input);
    }
    public int isValidLength(int length) {
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_VALID_LENGTH.getDescription());
        }
        return length;
    }
    public void isValidMove(String move) {
        List<String> validMoves = new ArrayList<>(Arrays.asList("U", "D"));
        if (!(validMoves.contains(move.toUpperCase()))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_VALID_MOVE.getDescription());
        }
    }
    public void isValidCommand(String command) {
        List<String> validCommands = new ArrayList<>(Arrays.asList("R", "Q"));
        if (!(validCommands.contains(command.toUpperCase()))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_VALID_COMMAND.getDescription());
        }
    }
}
