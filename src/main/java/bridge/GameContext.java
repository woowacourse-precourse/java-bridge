package bridge;

public class GameContext {
    private static final GameContext gameContext = new GameContext();

    private int tryCount = 1;
    private boolean success = false;
    private boolean quit = false;

    public static GameContext getInstance() {
        return gameContext;
    }

    public void increaseTryCount(){
        tryCount++;
    }

    public void transition(){
        success = true;
    }

    public void quit(){
        quit = true;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean hasQuit() {
        return quit;
    }
}
