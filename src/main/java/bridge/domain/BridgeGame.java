package bridge.domain;

import bridge.dto.BridgeCrossingDTO;

public class BridgeGame {
    private final Bridge bridge;
    private int nowLocation = 0;
    private int tryCount = 1;
    private BridgeCrossingStatus crossingStatus;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void move(String movingDirection) {
        crossingStatus = bridge.isRightTrack(nowLocation, movingDirection);
        nowLocation++;
    }

    public void retry() {
        nowLocation = 0;
        tryCount++;
    }

    public BridgeCrossingDTO toResponseDto() {
        return null;
    }
}
