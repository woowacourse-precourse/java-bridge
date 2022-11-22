package bridge;

public class Repository {
    private Game result;

    private int times;

    public Repository() {
        times = 0;
    }
    public Game getResult() {
        return result;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void save(Game game){
        if (result == null || result.getLocation() < game.getLocation()) {
            result = game;
        }
    }
}
