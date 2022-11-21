package bridge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeMapMaker {

    private static final String MOVE_SUCCESS = "O";
    private static final String MOVE_FAILURE = "X";
    private static final String BLANK = " ";

    private static final String UP_SIDE = "U";
    private static final String DOWN_SIDE = "D";

    private final List<String> bridge;

    public BridgeMapMaker(List<String> bridge) {
        this.bridge = bridge;
    }

    public PlayerMap getSuccessBridgeMap() {
        List<String> upSideMap = convertSideToMovingMap(UP_SIDE, MOVE_SUCCESS);
        List<String> downSideMap = convertSideToMovingMap(DOWN_SIDE, MOVE_SUCCESS);

        return new PlayerMap(upSideMap, downSideMap);
    }

    public PlayerMap getFailureBridgeMap() {
        List<String> upSideMap = convertSideToMovingMap(DOWN_SIDE, MOVE_FAILURE);
        List<String> downSideMap = convertSideToMovingMap(UP_SIDE, MOVE_FAILURE);

        return new PlayerMap(upSideMap, downSideMap);
    }

    private List<String> convertSideToMovingMap(String side, String moveStatus) {
        Map<String, String> status = Map.of(side, moveStatus);

        return bridge.stream()
                .map(s -> status.getOrDefault(s, BLANK))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "<BridgeMapMaker of bridge " + bridge + ">";
    }
}
