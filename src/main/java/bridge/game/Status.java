package bridge.game;

public enum Status {

    SUCCESS(2),
    CONTINUE(1),
    FAIL(0);

    private final int number;

    Status(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
