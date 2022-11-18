package bridge.model.validator;

@FunctionalInterface
public interface Validator {
    void validateInput(String input);
}
