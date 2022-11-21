package bridge;

public enum GameKeySet {
    UP("U"), DOWN("D"), RESTART("R"), QUIT("Q");

    private final String keySet;

    GameKeySet(String keySet) {
        this.keySet = keySet;
    }

    public String getKeySet() {
        return keySet;
    }
}
