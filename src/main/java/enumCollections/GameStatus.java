package enumCollections;

public enum GameStatus {
    CONTINUE("", "O"),
    SUCCESS("성공", "O"),
    FAILURE("실패", "X"),
    QUIT("Q", ""),
    RESTART("R", "");

    private String message;
    private String isSucceed;

    GameStatus(String inputMessage, String isSucceed) {
        this.message = inputMessage;
        this.isSucceed = isSucceed;
    }

    public static String getMessage(GameStatus gameStatus) {
        return gameStatus.message;
    }

    public static String isSucceed(GameStatus gameStatus) {
        return gameStatus.isSucceed;
    }
}
