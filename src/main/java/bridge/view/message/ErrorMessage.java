package bridge.view.message;

public abstract class ErrorMessage {
    public static final String INPUT_NUMBER_RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String VALIDATE_INTEGER_TYPE_ERROR = "[ERROR] 다리의 길이는 정수 형태여야 합니다.";
    public static final String INPUT_MOVE_TYPE_ERROR = "[ERROR] 이동할 칸은 U 또는 D만 입력 가능합니다.";
    public static final String INPUT_RETRY_ERROR = "[ERROR] 게임 재시작/종료는 R 또는 Q만 입력 가능합니다.";
    public static final String CONVERT_BRIDGE_NUMBER_ERROR = "[ERROR] 입력받은 길이에 대한 숫자는 0 또는 1의 숫자여야 합니다.";
}
