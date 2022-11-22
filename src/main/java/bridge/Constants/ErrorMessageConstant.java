package bridge.Constants;

public final class ErrorMessageConstant {

    private ErrorMessageConstant() {
    }

    private static final String PREFIX = "[ERROR] ";
    public static final String NOT_INTEGER =  PREFIX + "숫자만 입력 가능합니다.";
    public static final String INVALID_BRIDGE_LENGTH = PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INVALID_MOVING_COMMAND = PREFIX + "이동을 위해서 U 또는 D 만을 입력해 주세요.";
    public static final String INVALID_GAME_OVER_CONTROL_COMMAND = PREFIX + "게임 종료 여부 판단을 위해서 R 또는 Q 만을 입력해 주세요.";
    public static final String RANDOM_NUMBER_GENERATOR_OPERATION_FAILED = PREFIX + "다리를 만드는 과정에서 버그가 발생하였습니다. 게임을 재시작하여 주세요.";

}
