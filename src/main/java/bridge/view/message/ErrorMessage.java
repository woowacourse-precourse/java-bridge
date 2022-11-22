package bridge.view.message;

public abstract class ErrorMessage {

    public static final String ERROR_HEADER = "[ERROR] ";

    public static final String VALIDATE_INTEGER_TYPE = "다리의 길이는 정수 형태여야 합니다.";
    public static final String VALIDATE_BRIDGE_RANGE = "다리의 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String VALIDATE_BRIDGE_MOVE = "이동할 칸은 U 또는 D만 입력 가능합니다.";
    public static final String VALIDATE_GAME_RETRY = "게임 재시작/종료는 R 또는 Q만 입력 가능합니다.";
}
