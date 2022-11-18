package bridge.system.validation;

public abstract class RegexContainingOnlyValidator {
    public static void isOnlyConsistedOf(String target, String exceptionMessage, String... consistValues) {
        if (!target.matches(findRegexContainingOnly(consistValues))) {
            throw new IllegalArgumentException(exceptionMessage);
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
