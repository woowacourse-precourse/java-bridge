package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final PassingSpace passingSpace;

    public BridgeGame(Bridge bridge, PassingSpace passingSpace) {
        this.bridge = bridge;
        this.passingSpace = passingSpace;
    }

    public void move(int position, String selectedSpace) {
        Space space = Space.valueOf(selectedSpace);
        Movable movable = bridge.compareSpace(position, selectedSpace);
        passingSpace.add(space, movable);
    }

    public String drawPassingSpace() {
        return passingSpace.draw();
    }

    public boolean isRightSpace(int position, String selectedSpace) {
        Movable movable = bridge.compareSpace(position, selectedSpace);
        return movable.isMovable();
    }

    public boolean isSuccessCrossingBridge(int position) {
        return bridge.size() == position;
    }

    public boolean retry(String selectRetry) {
        Retry retry = Retry.valueOf(selectRetry);
        return retry.isRetry();
    }
}
