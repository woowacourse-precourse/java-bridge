package bridge;

public class Validator {
    private final String ERROR_MESSAGE = "[ERROR] ";
    private final String ERROR_NOT_INT = ERROR_MESSAGE + "다리 길이는 숫자여야 합니다.";
    private final String ERROR_NOT_VALID_LENGTH = ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String ERROR_NOT_VALID_MOVE = ERROR_MESSAGE + "이동할 칸은 U 또는 D여야 합니다.";
    private final String ERROR_NOT_VALID_COMMAND = ERROR_MESSAGE + "게임 재시도 여부는 R 또는 Q여야 합니다.";
    public void isInt(String input) {
        try {
            int length = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
    }
    public void isValidMove(String input) {

    }
    public void isValidCommand(String input) {

    }
}
