package enumCollections;

public enum GameStatus {
    CONTINUE(""),
    SUCCESS("성공"),
    FAILURE("실패");

    private String message;

    GameStatus(String inputMessage) {
        this.message = inputMessage;
    }

    public static String get(GameStatus gameStatus) {
        return gameStatus.message;
    }
}
