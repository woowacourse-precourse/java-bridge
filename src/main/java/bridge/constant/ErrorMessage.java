package bridge.constant;

public interface ErrorMessage {
    String PREFIX = "[ERROR] ";
    String INVALID_BRIDGE_SIZE_RANGE = "3 이상 20 이하의 숫자를 입력해주세요.";
    String INVALID_BLANK_INPUT = "공백을 입력할 수 없습니다.";
    String INVALID_MOVING_INPUT = "U 또는 D(대문자)만 입력할 수 있습니다.";
    String INVALID_NON_NUMERIC_INPUT = "숫자만 입력할 수 있습니다.";
    String INVALID_COMMAND_INPUT = "R 또는 Q(대문자)만 입력할 수 있습니다.";
}
