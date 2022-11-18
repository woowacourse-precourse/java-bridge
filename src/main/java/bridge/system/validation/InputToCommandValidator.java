package bridge.system.validation;

public class InputToCommandValidator extends RegexContainingOnlyValidator {
    public static final String INVALID_INPUT_VALUE_MESSAGE = "게임 재시작/종료 여부로는 대문자 R 또는 Q 둘 중 하나만 입력하실 수 있습니다.";

    public static void validate(String target) {
        isOnlyConsistedOf(target, INVALID_INPUT_VALUE_MESSAGE, "R", "Q");
    }
}
