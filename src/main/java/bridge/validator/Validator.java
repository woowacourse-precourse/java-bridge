package bridge.validator;

public interface Validator<T> {

    String prefix = "[ERROR] ";

    boolean test(T target);

    String getErrorMessage();
}
