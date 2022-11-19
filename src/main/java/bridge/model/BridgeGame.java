package bridge.model;

public class BridgeGame {
    private final Bridge bridge;
    private final PassingSpace passingSpace;
    private int numberOfTry;
    private int position;

    public BridgeGame(Bridge bridge, PassingSpace passingSpace) {
        this.bridge = bridge;
        this.passingSpace = passingSpace;
        numberOfTry = 0;
        position = 0;
    }

    public void move(String selectedSpace) {
        Space space = Space.valueOf(selectedSpace);
        Movable movable = bridge.compareSpace(position, selectedSpace);
        passingSpace.add(space, movable);
    }

    public String drawPassingSpace() {
        return passingSpace.toString();
    }

    public boolean isRightSpace(String selectedSpace) {
        Movable movable = bridge.compareSpace(position, selectedSpace);
        return movable.isMovable();
    }

    public boolean retry(String selectRetry) {
        Retry retry = Retry.valueOf(selectRetry);

        if (retry.isRetry()) {
            numberOfTry += 1;
            passingSpace.reset();
        }
        return retry.isRetry();
    }

    public boolean isSuccessCrossingBridge() {
        return bridge.size() == position;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }
}