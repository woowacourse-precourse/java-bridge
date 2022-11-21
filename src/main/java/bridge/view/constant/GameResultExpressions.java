package bridge.view.constant;

public enum GameResultExpressions {
    SUCCESS("성공"),
    FAIL("실패");

    private final String expression;

    public static String findExpressionByBooleanValue(boolean booleanValue) {
        if (booleanValue == true) {
            return SUCCESS.get();
        }
        return FAIL.get();
    }

    private GameResultExpressions (String expression) {
        this.expression = expression;
    }

    public String get() {
        return expression;
    }
}
