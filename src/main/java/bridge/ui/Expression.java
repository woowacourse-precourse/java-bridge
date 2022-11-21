package bridge;

public enum Expression {

    UP("U"),
    DOWN("D");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }


    public String expressThat() {
        return expression;
    }
}
