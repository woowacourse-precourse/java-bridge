package bridge.utils;

public enum GameState {
    WIN("win"),
    LOOSE("loose"),
    PLAYING("playing");

    private final String label;

    GameState(String label) {
        this.label =label;
    }

    public String getLabel() {
        return label;
    }
}
