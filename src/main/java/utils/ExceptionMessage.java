package utils;

public class ExceptionMessage {
    public static final String ERROR_MSG = "[ERROR] ";
    public static final String BRIDGE_SIZE_NOT_NUMERIC = ERROR_MSG + "다리 길이는 숫자여야 합니다.";
    public static final String BRIDGE_SIZE_NUM_INVALID = ERROR_MSG + "다리 길이는 3이상 20이하의 숫자여야 합니다.";
    public static final String MOVE_INPUT_INVALID = ERROR_MSG + "이동은 U(위) 또는 D(아래)만 입력 가능합니다.";
    public static final String GAME_OPTION_INVALID = ERROR_MSG + "게임은 R(재시작) 또는 Q(종료)만 입력 가능합니다.";
}
