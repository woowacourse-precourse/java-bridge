package bridge.validator;

public interface Validatable<T> {
    default void validate(T target, Validator<T> validator) {
        if (!validator.test(target)) {
            throw new IllegalArgumentException(validator.getErrorMessage());
        }
    }

    default void validate(T target, Validator<T>... validators) {
        for (Validator<T> validator : validators) {
            validate(target, validator);
        }
    }
}
