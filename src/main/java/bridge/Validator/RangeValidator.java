package bridge.Validator;

public interface RangeValidator {
    default boolean isValidRange(int minimum, int maximum, int input) {
        return input >= minimum && input <= maximum;
    }
}
