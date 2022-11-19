package bridge.messages;

public class ErrorMessage {
    public static final String BLOCK_SYMBOL_ERROR = "각 칸은 U또는 D문자로 이루어져 있어야 합니다.";
    public static final String RANDOM_NUMBER_ERROR = "각 칸은 0또는 1의 숫자로 랜덤 생성되어야 합니다.";

    private ErrorMessage() {
    }
}
