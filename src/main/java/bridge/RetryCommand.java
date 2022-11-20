package bridge;

public enum RetryCommand {
    QUIT('Q'), RETRY('R');

    private char value;

    RetryCommand(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
