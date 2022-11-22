package bridge.util;

@FunctionalInterface
public interface Validator<T> {
    void validate(T input);
}
