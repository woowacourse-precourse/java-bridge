package bridge.util;

public class ErrorMessage {
    private ErrorMessage() {
    }
    public static final String ERROR_MESSAGE = "[ERROR] %s";
    public static final String ERROR_GAME_COMMAND_INPUT = "R/Q 중 재시작 여부를 입력해 주세요.";
    public static final String ERROR_GENERATED_NUMBER = "0, 1 중의 숫자로만 다리를 생성할 수 있습니다.";
    public static final String ERROR_BRIDGE_SIZE_TYPE = "자연수만 입력해 주세요.";
    public static final String ERROR_BRIDGE_SIZE_OVER_INT = "입력 범위를 초과하였습니다.";
    public static final String ERROR_BRIDGE_SIZE_RANGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ERROR_MOVING_INPUT = "U/D 중 이동할 칸을 입력해 주세요.";
}
