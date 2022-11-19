package enumCollections;

public enum GameStatus {
    CONTINUE(""),
    SUCCESS(""),
    FAILURE(""),
    QUIT("Q"),
    RESTART("R");

    private String inputMessage;

    GameStatus(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public static String getInputMessage(GameStatus gameStatus) {
        return gameStatus.inputMessage;
    }
}
