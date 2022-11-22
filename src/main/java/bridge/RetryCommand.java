package bridge;

public enum RetryCommand {
    QUIT('Q'), RETRY('R');

    private final char value;

    RetryCommand(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static RetryCommand of(char c) {
        if(c != 'R' && c != 'Q')
            throw new IllegalArgumentException("잘못된 RetryCommand 입력.");
        if(c == 'Q')
            return QUIT;
        return RETRY;
    }
}
