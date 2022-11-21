package bridge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeMapMaker {

    private static final String UP_SIDE = "U";
    private static final String DOWN_SIDE = "D";

    private final List<String> bridge;

    public BridgeMapMaker(List<String> bridge) {
        this.bridge = bridge;
    }

    public PlayerMap getSuccessBridgeMap() {
        List<String> upSideMap = convertSideToMovingMap(UP_SIDE, MapStates.MOVE_SUCCESS);
        List<String> downSideMap = convertSideToMovingMap(DOWN_SIDE, MapStates.MOVE_SUCCESS);

        return new PlayerMap(upSideMap, downSideMap);
    }

    public PlayerMap getFailureBridgeMap() {
        List<String> upSideMap = convertSideToMovingMap(DOWN_SIDE, MapStates.MOVE_FAILURE);
        List<String> downSideMap = convertSideToMovingMap(UP_SIDE, MapStates.MOVE_FAILURE);

        return new PlayerMap(upSideMap, downSideMap);
    }

    private List<String> convertSideToMovingMap(String side, String moveStatus) {
        Map<String, String> status = Map.of(side, moveStatus);

        return bridge.stream()
                .map(s -> status.getOrDefault(s, MapStates.BLANK))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "<BridgeMapMaker of bridge " + bridge + ">";
    }
}
