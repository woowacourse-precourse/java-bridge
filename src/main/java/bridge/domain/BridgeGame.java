package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import bridge.dto.BridgeCrossingDTO;

public class BridgeGame {
    private static final Map<String, Integer> directionToList = new HashMap<>() {{
        put("U", 0);
        put("D", 1);
    }};
    private final Bridge bridge;
    private List<List<String>> footPrint = new ArrayList<>();
    private int tryCount;
    private BridgeCrossingStatus crossingStatus;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        tryCount = 1;
        footPrint.add(new ArrayList<>());
        footPrint.add(new ArrayList<>());
    }

    public void move(String movingDirection) {
        crossingStatus = bridge.isRightTrack(footPrint.get(0).size(), movingDirection);
        leaveFootPrint(movingDirection, directionToList.get("U"));
        leaveFootPrint(movingDirection, directionToList.get("D"));
    }

    public void leaveFootPrint(String movingDirection, int upAndDown) {
        if (directionToList.get(movingDirection) != upAndDown) {
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
        footPrint.get(0).clear();
        footPrint.get(1).clear();
    }

}
