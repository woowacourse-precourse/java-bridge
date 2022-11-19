package bridge;

public enum SystemOperation {
    RETRY("R"),
    QUIT("Q");

    private String value;

    SystemOperation(String value) {
        this.value = value;
    }
}
