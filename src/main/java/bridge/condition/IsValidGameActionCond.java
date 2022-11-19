package bridge.condition;

public class IsValidGameActionCond implements Condition {

    private static final Condition instance = new IsValidGameActionCond();
    private static final String OPERATION_REGEX = "U|D";

    public static Condition getInstance() {
        return instance;
    }

    private IsValidGameActionCond() {
    }

    @Override
    public boolean test(String input) {
        return input.matches(OPERATION_REGEX);
    }
}
