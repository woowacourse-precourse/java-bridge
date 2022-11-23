package bridge.constants;

public enum ValidMessage {
    VALID(true, "O"),
    INVALID(false, "X");

    private final boolean isValid;
    private final String printOX;

    ValidMessage(boolean isValid, String printOX) {
        this.isValid = isValid;
        this.printOX = printOX;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public String getPrintOX() {
        return printOX;
    }
}
