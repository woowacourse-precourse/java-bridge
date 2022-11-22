package bridge.utils;

public class ErrorMessage {
    private static final String ERROR_TAG = "[ERROR] ";
    public static final String BRIDGE_SIZE_NOT_INTEGER = ERROR_TAG + "다리 길이는 숫자만 가능합니다.";
    public static final String BRIDGE_SIZE_OUT_OF_RANGE = ERROR_TAG + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVING_NOT_OPTIONS = ERROR_TAG + "U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.";
    public static final String GAME_COMMAND_NOT_OPTIONS = ERROR_TAG + "R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.";
    public static final String NUMBER_NOT_OPTIONS = ERROR_TAG + "정의 되지 않은 숫자 접근입니다.";

    public static final String INDEX_OUT_OF_BOUNDS = ERROR_TAG + "유효하지 않은 인덱스 접근입니다.";
}