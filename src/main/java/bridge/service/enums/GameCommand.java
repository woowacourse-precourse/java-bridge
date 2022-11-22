package bridge.service.enums;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String type;

    GameCommand(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}