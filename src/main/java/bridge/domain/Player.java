package bridge.domain;

public class Player {

    private final int INITIAL_PLAYER_POSITION = -1;
    private final int INITIAL_PLAYER_NUMBER_OF_RETRY = 1;
    private final boolean INITIAL_PLAYER_ALIVE = true;


    private int numberOfRetry;
    private int index;
    private boolean alive;

    public Player() {
        index = INITIAL_PLAYER_POSITION;
        alive = INITIAL_PLAYER_ALIVE;
        numberOfRetry = INITIAL_PLAYER_NUMBER_OF_RETRY;
    }

    public boolean getAlive() {
        return alive;
    }

    public int getIndex() {
        return index;
    }

    public int getNumberOfRetry() {
        return numberOfRetry;
    }

    public void moving() {
        index++;
    }

    public void dead() {
        alive = false;
    }

    public void revive() {
        index = INITIAL_PLAYER_POSITION;
        alive = INITIAL_PLAYER_ALIVE;
        numberOfRetry++;
    }
}
