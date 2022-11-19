package bridge.domain.message;

public class ErrorMessage {
    public static final String INPUT_IS_NUMERIC = "[ERROR] 숫자 이외의 값을 입력하실수 없습니다.";
    public static final String BRIDGE_SIZE_NOT_ZERO = "[ERROR] 다리의 크기는 0이 될 수 없습니다.";
    public static final String BRIDGE_GENERATE_ERROR = "[ERROR] 다리를 생성하는 메서드가 정해지지 않은 값을 생성하였습니다.";
    public static final String BRIDGE_INPUT_ONLY_UP_AND_DOWN = "[ERROR] 이동할 입력값은 U 또는 D만 입력하실 수 있습니다.";
}
