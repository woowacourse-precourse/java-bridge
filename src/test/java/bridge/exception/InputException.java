package bridge.exception;

public interface InputException {

    default void exception(String input) {

    }

    default void exception(int input) {

    }

    default void exception(String input, String terms1, String terms2) {

    }

}
