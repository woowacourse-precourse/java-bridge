package bridge.message;

public class ErrorMessage {
    private ErrorMessage() {}

    public static String BRIDGE_LENGTH_NUMBER_ERROR_MESSAGE = "[ERROR] 다리의 길이는 숫자여야 합니다.";
    public static String BRIDGE_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static String BRIDGE_EMPTY_ERROR_MESSAGE = "[ERROR] 다리 길이는 빈 값을 입력할 수 없습니다.";
    public static String MOVING_BRIDGE_STRING_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸)로만 입력할 수 있습니다.";
    public static String GAME_RETRY_STRING_ERROR_MESSAGE = "[ERROR] 이동할 칸은 R(재시도)과 Q(종료)로만 입력할 수 있습니다.";

}
