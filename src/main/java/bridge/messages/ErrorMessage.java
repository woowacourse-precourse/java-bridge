package bridge.messages;

public class ErrorMessage {
    public static final String BLOCK_SYMBOL_ERROR = "[ERROR] 각 칸은 U또는 D문자로 이루어져 있어야 합니다.";
    public static final String RANDOM_NUMBER_ERROR = "[ERROR] 각 칸은 0또는 1의 숫자로 랜덤 생성되어야 합니다.";
    public static final String NON_NUMERIC_BRIDGE_SIZE_ERROR = "[ERROR] 다리의 사이즈는 숫자만 입력해야 합니다.";
    public static final String OUTBOUND_BRIDGE_SIZE_ERROR = "[ERROR] 다리의 사이즈는 3이상 20이하여야 합니다.";
    public static final String INVALID_BLOCK_COMMAND_ERROR = "[ERROR] 이동할 칸은 U또는 D만 입력해야 합니다.";

    private ErrorMessage() {
    }
}
