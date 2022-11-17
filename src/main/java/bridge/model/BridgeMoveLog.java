package bridge.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class BridgeMoveLog {

    private final Map<BridgeType, List<String>> moveLog;

    private static final String EMPTY = " ";

    public BridgeMoveLog(int size) {
        this.moveLog = initLog(size);
    }

    private Map<BridgeType, List<String>> initLog(int size) {
        return new EnumMap<>(BridgeType.class) {{
            for (BridgeType bridgeType : BridgeType.values()) {
                put(bridgeType, new ArrayList<>(size));
            }
        }};
    }

    public void writeLog(BridgeType selectBridgeType, String status) {
        for (BridgeType bridgeType : moveLog.keySet()) {
            if (selectBridgeType == bridgeType) {
                moveLog.get(bridgeType).add(status);
                continue;
            }

            moveLog.get(bridgeType).add(EMPTY);
        }
    }

    public void resetLog() {
        for (List<String> log : moveLog.values()) {
            log.clear();
        }
    }

    public Map<BridgeType, List<String>> getMoveLog() {
        return moveLog;
    }
}
