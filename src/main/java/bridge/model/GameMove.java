package bridge.model;

public enum GameMove {
    UP("U"),
    DOWN("D");
    private final String letter;

    GameMove(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
