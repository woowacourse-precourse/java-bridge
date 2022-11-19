package bridge.domain;

public enum RetryCommand {

    RETRY("R"),
    QUIT("Q");

    private final String name;

    RetryCommand(String name) {
        this.name = name;
    }
}
