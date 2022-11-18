package bridge;

public class GameStatus {
    private String gameHistory;
    private int flag = -1;

    public GameStatus(GameUser gameUser) {
        this.gameHistory = gameUser.toString();
    }
}
