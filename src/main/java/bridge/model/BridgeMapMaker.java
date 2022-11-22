package bridge.model;

import bridge.model.utils.BridgeSides;
import bridge.model.utils.MapStates;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeMapMaker {

    private final List<String> bridge;

    public BridgeMapMaker(List<String> bridge) {
        this.bridge = bridge;
    }

    public PlayerMap makeSuccessBridgeMap() {
        List<String> upSideMap = convertSideToMovingMap(BridgeSides.up(), MapStates.moveSuccess());
        List<String> downSideMap = convertSideToMovingMap(BridgeSides.down(), MapStates.moveSuccess());

        return new PlayerMap(upSideMap, downSideMap);
    }

    public PlayerMap makeFailureBridgeMap() {
        List<String> upSideMap = convertSideToMovingMap(BridgeSides.down(), MapStates.moveFailure());
        List<String> downSideMap = convertSideToMovingMap(BridgeSides.up(), MapStates.moveFailure());

        return new PlayerMap(upSideMap, downSideMap);
    }

    private List<String> convertSideToMovingMap(String side, String moveStatus) {
        Map<String, String> status = Map.of(side, moveStatus);

        return bridge.stream()
                .map(s -> status.getOrDefault(s, MapStates.blank()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("< BridgeMapMaker bridge=%s >", bridge);
    }
}
