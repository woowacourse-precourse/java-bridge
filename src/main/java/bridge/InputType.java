package bridge;

public enum InputType {
    UP('U'),
    DOWN('D'),
    RETRY('R'),
    QUIT('Q');

    private final Character value;

    InputType(Character value) {
        this.value = value;
    }
}
