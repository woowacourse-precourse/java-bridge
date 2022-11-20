package bridge;

public enum MoveCommand {
    UP('U'), DOWN('D');

    private char value;

    MoveCommand(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
