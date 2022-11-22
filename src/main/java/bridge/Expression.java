package bridge;

import static bridge.UserInterface.INVALID_EXCEPTION;

import java.util.Arrays;

public enum Expression {

    UP("U"),
    DOWN("D");

    private final String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    public static Expression validate(String readLine) {
        return Arrays.stream(values())
                .filter(predicate -> predicate.expressThat().equals(readLine))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_EXCEPTION.interact()));
    }

    public String expressThat() {
        return expression;
    }
}
