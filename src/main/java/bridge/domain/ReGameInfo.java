package bridge.domain;

public enum ReGameInfo {
    RE_GAME("R"),
    EXIT("Q");

    private final String reGameCommand;

    ReGameInfo(String reGameCommand) {
        this.reGameCommand = reGameCommand;
    }

    public String getReGameCommand() {
        return reGameCommand;
    }
}
