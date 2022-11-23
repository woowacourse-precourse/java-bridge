package bridge.validator;

public interface Validator<T> {

    String prefix = "[ERROR] ";

    boolean test(T target);

    String getMessage();

    default void validate(T target) {
        if (!test(target)) {
            throw new IllegalArgumentException(prefix + getMessage());
        }
    }
}
