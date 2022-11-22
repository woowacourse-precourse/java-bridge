package bridge;

public class GameResult {
    private GameSimulation gameResult;
    private int count;

    public GameResult() {
        count = 0;
    }

    public GameSimulation getGameResult() {
        return gameResult;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void save(GameSimulation game) {
        if (gameResult == null
                || gameResult.getLocation() < game.getLocation()) {
            gameResult = game;
        }
    }
}
