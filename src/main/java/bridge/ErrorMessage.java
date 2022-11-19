package bridge;

public class ErrorMessage {
    private static final String HEADER = "[ERROR] ";
    public static final String INCORRECT_BRIDGE_SIZE = HEADER + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INCORRECT_BRIDGE_DIRECTION = HEADER + "경로에 위(U), 아래(D)로만 구성되어야 합니다.";
}
