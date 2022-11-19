package bridge.domain;

import java.util.List;

import bridge.dto.BridgeCrossingDTO;

public class BridgeGame {
    private static List<String> footPrint;

    private final Bridge bridge;
    private int tryCount;
    private BridgeCrossingStatus crossingStatus;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        tryCount = 1;
    }

    public void move(String movingDirection) {
        crossingStatus = bridge.isRightTrack(footPrint.size(), movingDirection);
        footPrint.add(movingDirection);
    }

    public BridgeCrossingDTO toResponseDto() {

        return null;
    }

    public void retry() {
        tryCount++;
    }

}
