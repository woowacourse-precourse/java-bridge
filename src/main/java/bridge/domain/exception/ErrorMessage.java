package bridge.domain.exception;

public class ErrorMessage {

    private static final String PREFIX = "[ERROR] ";
    public static final String ERROR_BRIDGE_SIZE = PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ERROR_MOVING_VALUE = PREFIX + "이동할 칸은 U(위) 또는 D(아래) 둘 중 하나여야 합니다.";
    public static final String ERROR_GAME_COMMAND = PREFIX + "게임 재시도 또는 게임 종료 명령어는 R(재시도) 또는 Q(종료) 둘 중 하나여야 합니다.";
}
