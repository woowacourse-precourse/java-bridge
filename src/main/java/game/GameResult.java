package game;

public enum GameResult {

    CORRECT_FLOOR("O"),
    WRONG_FLOOR("X");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResultMessage() {
        return result;
    }
}
