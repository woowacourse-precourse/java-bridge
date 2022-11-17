package bridge;

public enum BridgeConverter {
    DOWN(0, "D"),
    UP(1, "U");

    private int number;
    private String message;

    BridgeConverter(int number, String message) {
        this.number = number;
        this.message = message;
    }
}
