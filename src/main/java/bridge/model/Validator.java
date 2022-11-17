package bridge.model;

@FunctionalInterface
public interface Validator {
    void validateInput(String input);
}
