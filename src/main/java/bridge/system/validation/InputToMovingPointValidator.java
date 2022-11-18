package bridge.system.validation;

public class InputToMovingPointValidator extends RegexContainingOnlyValidator {
    public static final String INVALID_INPUT_VALUE_MESSAGE = "이동할 칸으로는 대문자 U 또는 D 둘 중 하나만 입력하실 수 있습니다.";

    public static void validate(String target) {
        isOnlyConsistedOf(target, INVALID_INPUT_VALUE_MESSAGE, "U", "D");
    }
}
