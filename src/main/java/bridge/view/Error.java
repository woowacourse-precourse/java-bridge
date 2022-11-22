package bridge.view;

import bridge.resource.ErrorType;

public class Error extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] %s";

    public Error(ErrorType type) {
        System.out.println(String.format(ERROR, type.getMessage()));
        throw new IllegalArgumentException();
    }
}
