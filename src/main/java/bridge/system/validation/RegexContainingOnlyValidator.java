package bridge.system.validation;

public abstract class RegexContainingOnlyValidator {

    public static final String REGEX_PREFIX = "^[";
    public static final String REGEX_POSTFIX = "]{1}$";

    public static void isOnlyConsistedOf(String target, String exceptionMessage, String... consistValues) {
        if (!target.matches(findRegexContainingOnly(consistValues))) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static String findRegexContainingOnly(String[] consistValues) {
        StringBuilder builder = new StringBuilder();
        builder.append(REGEX_PREFIX);
        for (String consistValue : consistValues) {
            builder.append(consistValue);
        }
        builder.append(REGEX_POSTFIX);

        return builder.toString();
    }
}
