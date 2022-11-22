package bridge;

public class Exception {
    static final String ERROR_HEADER = "[ERROR] ";
    static final String WRONG_MOVING_MESSAGE = ERROR_HEADER + "방향은 U 혹은 D 만이 입력가능합니다.";
    static final String WRONG_COMMAND_MESSAGE = ERROR_HEADER + "커맨드는 R 혹은 Q만이 입력가능합니다.";
    static final String WRONG_SIZE_INPUT = ERROR_HEADER + "다리 길이는 3 이상 20 이하의 숫자여야 합니다.";

    public void isMovingDirectionCorrect(String direction) {
        if (direction != "U" && direction != "D") {
            throw new IllegalArgumentException(WRONG_MOVING_MESSAGE);
        }
    }

    public void isCommandCorrect(String cmd) {
        if (cmd != "R" && cmd != "Q") {
            throw new IllegalArgumentException(WRONG_COMMAND_MESSAGE);
        }
    }

    public void isSizeInputCorrect(String size) {

        try {
            int intSize = Integer.parseInt(size);

            if (intSize < 3 || intSize > 20) {
                throw new IllegalArgumentException(WRONG_SIZE_INPUT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_SIZE_INPUT);
        }
    }
}
