package bridge.domain;

public final class ErrorMessageConstant {

    private ErrorMessageConstant() {
    }

    private static final String PREFIX = "[ERROR] ";
    public static final String NOT_INTEGER =  PREFIX + "숫자만 입력 가능합니다.";
    public static final String INVALID_BRIDGE_LENGTH = PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INVALID_MOVING_COMMAND = PREFIX + "이동을 위해서 U 또는 D 만을 입력해 주세요.";
    public static final String INVALID_GAME_OVER_CONTROL_COMMAND = PREFIX + "게임 종료 여부 판단을 위해서 R 또는 Q 만을 입력해 주세요.";
}
