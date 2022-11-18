package bridge.utils;

public class ErrorMessage {
    private static final String ERROR_TAG = "[ERROR] ";

    public static final String BRIDGE_SIZE_NOT_INTEGER = ERROR_TAG + "다리 길이는 숫자만 가능합니다.";
    public static final String BRIDGE_SIZE_OUT_OF_RANGE = ERROR_TAG + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static final String MOVING_NOT_OPTIONS = ERROR_TAG + "U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.";

    public static final String GAME_COMMAND_NOT_OPTIONS = ERROR_TAG + "R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.";

    public static final String RANDOM_NUMBER_NOT_OPTIONS = ERROR_TAG + "존재하지 않는 무작위 값 입니다.";
}