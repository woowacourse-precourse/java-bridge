package bridge.model.gameResult;

public class GameResultDTO {
    public String map;
    public boolean succeed;
    public int numberOfAttempts;

    private GameResultDTO(String map, boolean succeed, int numberOfAttempts) {
        this.map = map;
        this.succeed = succeed;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static GameResultDTO of(GameResult gameResult) {
        return new GameResultDTO(
                gameResult.map,
                gameResult.succeed,
                gameResult.numberOfAttempts
        );
    }

}