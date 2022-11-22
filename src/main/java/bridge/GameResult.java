package bridge;

public class GameResult {
    private GameSimulation result;
    private int count;

    public GameResult() {
        count = 0;
    }

    public GameSimulation getResult() {
        return result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void save(GameSimulation game) {
        if (result == null
                || result.getLocation() < game.getLocation()) {
            result = game;
        }
    }
}
