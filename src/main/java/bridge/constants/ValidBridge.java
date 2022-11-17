package bridge.constants;

public enum ValidBridge {

    U(1),
    D(0);

    final private int validNumber;

    ValidBridge(int validNumber) {
        this.validNumber = validNumber;
    }

    public int getValidNumber() {
        return validNumber;
    }
}
