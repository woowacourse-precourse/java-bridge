package bridge.constant;

public enum GameKeyboard {
    UP("U"), DOWN("D"), RESTART("R"), QUIT("Q"), WRONG_ANSWER("X");

    private final String letter;

    GameKeyboard(String letter) {
        this.letter = letter;
    }

    public String letter() {
        return letter;
    }
}
