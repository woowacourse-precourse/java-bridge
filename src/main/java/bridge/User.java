package bridge;

public class User {

    public static final int DEAD = 0;
    public static final int LIVE = 1;

    private final FootPrints footPrints;
    private int currentLocation;
    private int tryCount;


    public User() {
        currentLocation = 0;
        tryCount = 1;
        footPrints = new FootPrints();
    }

    public int cross(Bridge bridge, String direction) {
        if (bridge.canCross(currentLocation, direction)) {
            currentLocation++;
            return LIVE;
        }
        return DEAD;
    }

    public void recordStep(int status, String direction) {
        footPrints.add(status, direction);
    }

    public boolean isLocateAt(int location) {
        return currentLocation == location;
    }

    public String getFootPrintsLog() {
        return footPrints.toString();
    }

    public void prepareToRestart() {
        footPrints.reset();
        currentLocation = 0;
        tryCount++;
    }
}
