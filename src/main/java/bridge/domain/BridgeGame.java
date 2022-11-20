package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bridge.dto.BridgeCrossingDTO;

public class BridgeGame {
    private static final Map<String, Integer> map = new HashMap<>() {{
        put("U", 0);
        put("D", 1);
    }};
    private static List<List<String>> footPrint;

    private final Bridge bridge;
    private int tryCount;
    private BridgeCrossingStatus crossingStatus;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        tryCount = 1;
    }

    public void move(String movingDirection) {
        crossingStatus = bridge.isRightTrack(footPrint.size(), movingDirection);
        leaveFootPrint(movingDirection, 0);
        leaveFootPrint(movingDirection, 1);
    }

    public void leaveFootPrint(String movingDirection, int upAndDown) {
        if (map.get(movingDirection) != upAndDown) {
            footPrint.get(upAndDown).add(" ");
            return;
        }
        if (crossingStatus.equals(BridgeCrossingStatus.FAIL)) {
            footPrint.get(upAndDown).add("X");
            return;
        }
        footPrint.get(upAndDown).add("O");
    }

    public BridgeCrossingDTO toResponseDto() {
        return new BridgeCrossingDTO(footPrint, tryCount, crossingStatus.getStatus());
    }

    public void retry() {
        tryCount++;
    }

}
