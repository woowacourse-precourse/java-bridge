package bridge.domain;

public enum Command {
    UP(1, 'U'),
    DOWN(0, 'D');

    private final int statusInteger;
    private final char statusChar;

    Command(int statusInteger, char statusChar) {
        this.statusInteger = statusInteger;
        this.statusChar = statusChar;
    }

    public int getStatusInteger() {
        return statusInteger;
    }

    public char getStatusChar() {
        return statusChar;
    }
}
