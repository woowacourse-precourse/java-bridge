package bridge.util.validator;

public abstract class Validator {
    abstract void validate(String input) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
