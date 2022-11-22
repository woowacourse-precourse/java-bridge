package bridge.enums;

public enum Position {
    UP("U"), DOWN("D");

    private String message;

    Position(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
