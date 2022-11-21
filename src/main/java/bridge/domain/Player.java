package bridge.domain;

public class Player {

    private static final int INITIAL_PLAYER_POSITION = -1;
    private static final int INITIAL_PLAYER_NUMBER_OF_RETRY = 1;
    private static final boolean INITIAL_PLAYER_ALIVE = true;


    private static int numberOfRetry;
    private static int index;
    private static boolean alive;

    public static void set() {
        index = INITIAL_PLAYER_POSITION;
        alive = INITIAL_PLAYER_ALIVE;
        numberOfRetry = INITIAL_PLAYER_NUMBER_OF_RETRY;
    }

    public static boolean getAlive() {
        return alive;
    }

    public static int getIndex() {
        return index;
    }

    public static int getNumberOfRetry() {
        return numberOfRetry;
    }

    public static void moving() {
        index++;
    }

    public static void dead() {
        alive = false;
    }

    public static void revive() {
        index = INITIAL_PLAYER_POSITION;
        alive = INITIAL_PLAYER_ALIVE;
        numberOfRetry++;
    }

    public static boolean playerCanGo(int inputPlayerIndex, String direction) {
        return Bridge.getStepInBridge(inputPlayerIndex).equals(direction);
    }
}
