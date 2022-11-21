package bridge.utils;

public enum GameState {
    WIN,
    LOOSE,
    PLAYING;

    public boolean isEqual(String label) {
        return this.name().equals(label);
    }
}
