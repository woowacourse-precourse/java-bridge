package bridge.system.validation;

public class InputToCommandValidator {
    public static final String INVALID_INPUT_VALUE_MESSAGE = "게임 재시작/종료 여부로는 대문자 R 또는 Q 둘 중 하나만 입력하실 수 있습니다.";

    public static void validate(String target) {
        isOnlyConsistedOf(target, "R", "Q");
    }

    private static void isOnlyConsistedOf(String target, String... consistValues) {
        if (!target.matches(findRegexContainingOnly(consistValues))) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
        }
    }

    private static String findRegexContainingOnly(String[] consistValues) {
        StringBuilder builder = new StringBuilder();
        builder.append("^[");
        for (String consistValue : consistValues) {
            builder.append(consistValue);
        }
        builder.append("]{1}$");

        return builder.toString();
    }
}
