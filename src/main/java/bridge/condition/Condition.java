package bridge.condition;

public interface Condition {

    boolean test(String input);

    IllegalArgumentException getException();
}
