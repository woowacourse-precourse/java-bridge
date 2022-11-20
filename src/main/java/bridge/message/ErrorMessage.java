package bridge.message;

public class ErrorMessage {
    private static final String HEADER = "[ERROR] ";
    public static final String INCORRECT_BRIDGE_SIZE = HEADER + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INCORRECT_BRIDGE_DIRECTION = HEADER + "경로에 위(U), 아래(D)로만 구성되어야 합니다.";
    public static final String INCORRECT_MOVING = HEADER + "U 혹은 D를 입력하여야 합니다.(U - 위, D - 아래)";
    public static final String INCORRECT_GAME_COMMAND = HEADER + "R 혹은 Q를 입력하여야 합니다.(R - 재시도, Q - 종료)";
}
