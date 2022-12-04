package bridge.util.validator;

public abstract class Validator {
    abstract int validate(String input) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
