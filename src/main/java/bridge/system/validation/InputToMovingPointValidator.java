package bridge.system.validation;

public class InputToMovingPointValidator {

    public static final String INVALID_INPUT_VALUE_MESSAGE = "이동할 칸으로는 대문자 U 또는 D 둘 중 하나만 입력하실 수 있습니다.";

    public static void validate(String target) {
        isOnlyConsistedOf(target, "U", "D");
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
