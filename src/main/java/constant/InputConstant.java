package constant;

public enum InputConstant {
    UP_SIDE("U"),
    DOWN_SIDE("D"),
    RETRY("R"),
    QUIT("Q");

    public final String inputConstant;

    InputConstant(final String inputConstant) {
        this.inputConstant = inputConstant;
    }

    public String getConstant() {
        return inputConstant;
    }
}
