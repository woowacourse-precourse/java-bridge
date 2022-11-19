package bridge.model;

public class BridgeGame {
    private final Bridge bridge;
    private final PassingSpace passingSpace;
    private int numberOfTry;
    private int position;
    private boolean isRightSpace;

    public BridgeGame(Bridge bridge, PassingSpace passingSpace) {
        this.bridge = bridge;
        this.passingSpace = passingSpace;
        numberOfTry = 0;
        reset();
    }

    private void reset() {
        position = 0;
        passingSpace.reset();
        isRightSpace = true;
    }

    public void move(String selectedSpace) {
        Space space = Space.valueOf(selectedSpace);
        Movable movable = bridge.compareSpace(position, selectedSpace);
        passingSpace.add(space, movable);
        judgeSuccessMoving(selectedSpace);
        position += 1;
    }

    public String drawPassingSpace() {
        return passingSpace.toString();
    }

    public void judgeSuccessMoving(String selectedSpace) {
        Movable movable = bridge.compareSpace(position, selectedSpace);
        isRightSpace =  movable.isMovable();
    }

    public boolean retry(String selectRetry) {
        Retry retry = Retry.valueOf(selectRetry);

        if (retry.isRetry()) {
            numberOfTry += 1;
            reset();
        }
        return retry.isRetry();
    }

    public boolean isSuccessCrossingBridge() {
        return bridge.size() == position;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public boolean isRightSpace() {
        return isRightSpace;
    }
}