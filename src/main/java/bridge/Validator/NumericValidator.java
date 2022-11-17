package bridge.Validator;

public interface NumericValidator {
    default boolean isNumeric(final String input) {
        return input != null && !input.equals("") && input.chars().allMatch(Character::isDigit);
    }
}
