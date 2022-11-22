package bridge.condition;

import bridge.exception.NotAllowedSystemOperationException;

public class IsValidSystemActionCond implements Condition {

    private static final Condition instance = new IsValidSystemActionCond();
    private static final String OPERATION_REGEX = "Q|R";

    public static Condition getInstance() {
        return instance;
    }

    private IsValidSystemActionCond() {
    }

    @Override
    public boolean test(String input) {
        return input.matches(OPERATION_REGEX);
    }

    @Override
    public IllegalArgumentException getException() {
        return new NotAllowedSystemOperationException();
    }
}
