package bridge.model;

public enum GameMove {
    UP("U"),
    DOWN("D"),
    NOT_FOUND("");

    private final String letter;

    GameMove(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static GameMove find(String letter) {
        for (GameMove gameMove : GameMove.values()) {
            if (gameMove.letter.equals(letter)) {
                return gameMove;
            }
        }
        return NOT_FOUND;
    }
}
