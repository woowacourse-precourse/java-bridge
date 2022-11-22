package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private final String ERROR_MESSAGE = "[ERROR] ";
    private final String ERROR_NOT_INT = ERROR_MESSAGE + "다리 길이는 숫자여야 합니다.";
    private final String ERROR_NOT_VALID_LENGTH = ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String ERROR_NOT_VALID_MOVE = ERROR_MESSAGE + "이동할 칸은 U 또는 D여야 합니다.";
    private final String ERROR_NOT_VALID_COMMAND = ERROR_MESSAGE + "게임 재시도 여부는 R 또는 Q여야 합니다.";
    public int isInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
        return Integer.parseInt(input);
    }
    public int isValidLength(int length) {
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_LENGTH);
        }
        return length;
    }
    public void isValidMove(String move) {
        List<String> validMoves = new ArrayList<>(Arrays.asList("U", "D"));
        if (!(validMoves.contains(move.toUpperCase()))) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MOVE);
        }
    }
    public void isValidCommand(String command) {
        List<String> validCommands = new ArrayList<>(Arrays.asList("R", "Q"));
        if (!(validCommands.contains(command.toUpperCase()))) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_COMMAND);
        }
    }
}
