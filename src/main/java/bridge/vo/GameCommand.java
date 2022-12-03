package bridge.vo;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private String value;

    GameCommand(String value) {
        this.value = value;
    }
}
