package bridge.domain;

public class Player {

    private static int numberOfRetry;
    private static int index;
    private static boolean alive;

    public static void set() {
        numberOfRetry = 1;
        index = -1;
        alive = true;
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
        index = -1;
        alive = true;
        numberOfRetry++;
    }
}
