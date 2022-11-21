package bridge.utils.enums;

public enum GameState {
    WIN("성공"),
    LOOSE("실패"),
    PLAYING("진행 중");

    private final String label;

    GameState(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isEqual(String label) {
        return this.name().equals(label);
    }
}
