package bridge.domain;

import bridge.type.BridgeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveLog {
    private final Map<BridgeType, List<String>> bridgeMoveLog;

    public MoveLog(int size) {
        this.bridgeMoveLog = initMoveLog(size);
    }

    private Map<BridgeType, List<String>> initMoveLog(int size) {
        Map<BridgeType, List<String>> log = new HashMap<>();
        log.put(BridgeType.UP, new ArrayList<>(size));
        log.put(BridgeType.DOWN, new ArrayList<>(size));
        return log;
    }

    public void updateMoveLog(BridgeType chosenBridgeType, String status) {
        bridgeMoveLog.get(chosenBridgeType).add(status);
    }

    public void clearMoveLog() {
        for (List<String> bridgeMoveLogs : bridgeMoveLog.values()) {
            bridgeMoveLogs.clear();
        }
    }

    public Map<BridgeType, List<String>> getBridgeMoveLog() {
        return this.bridgeMoveLog;
    }

}