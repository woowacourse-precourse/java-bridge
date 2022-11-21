package bridge.util.validator;

@FunctionalInterface
public interface Validator<T> {
    void validate(T input);
}
