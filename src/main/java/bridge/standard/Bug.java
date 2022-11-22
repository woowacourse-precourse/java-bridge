package bridge.standard;

public class Bug {

    public static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String SIZE_PATTERN = "^[0-9]*$";
    public static final String MOVING_PATTERN = "[" + Rule.UP_CODE + Rule.DOWN_CODE + "]";
    public static final String GAME_COMMAND_PATTERN = "[" + Rule.RESTART_CODE + Rule.QUIT_CODE + "]";

    public static final String INPUT_ONLY_NATURAL_NUMBER = "다리 길이는 자연수를 숫자로 입력해야 합니다.";
    public static final String INPUT_BETWEEN_THREE_AND_TWENTY = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INPUT_U_OR_D = "위 칸은 U, 아래 칸은 D로만 입력 가능합니다.";
    public static final String INPUT_R_OR_Q = "재시작은 R, 종료는 Q로만 입력 가능합니다.";

    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;

    public static void validateChar(String input, String pattern, String errorMessage) {
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException(Bug.ERROR_MESSAGE + errorMessage);
        }
    }

    public static void validateNumber(int size, String errorMessage) {
        if (size < MINIMUM_SIZE || MAXIMUM_SIZE < size) {
            throw new IllegalArgumentException(Bug.ERROR_MESSAGE + errorMessage);
        }
    }

}