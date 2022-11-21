package bridge.system.validation;

import java.util.List;

public abstract class RegexContainingOnlyValidator {

    public static final String REGEX_PREFIX = "^[";
    public static final String REGEX_POSTFIX = "]{1}$";

    public static void isOnlyConsistedOf(String target, String exceptionMessage, List<String> consistValues) {
        if (!target.matches(findRegexContainingOnly(consistValues))) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static String findRegexContainingOnly(List<String> consistValues) {
        StringBuilder builder = new StringBuilder();
        makeRegex(consistValues, builder);

        return builder.toString();
    }

    private static void makeRegex(List<String> consistValues, StringBuilder builder) {
        builder.append(REGEX_PREFIX);
        for (String consistValue : consistValues) {
            builder.append(consistValue);
        }
        builder.append(REGEX_POSTFIX);
    }
}
