package bridge.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class BridgeMoveLog {

    private final Map<TypeOfBridge, List<String>> moveLog;

    private static final String EMPTY = " ";

    public BridgeMoveLog(int size) {
        this.moveLog = initLog(size);
    }

    private Map<TypeOfBridge, List<String>> initLog(int size) {
        return new EnumMap<>(TypeOfBridge.class) {{
            for (TypeOfBridge bridgeType : TypeOfBridge.values()) {
                put(bridgeType, new ArrayList<>(size));
            }
        }};
    }

    public void writeLog(TypeOfBridge selectBridgeType, String status) {
        for (TypeOfBridge bridgeType : moveLog.keySet()) {
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

    public Map<TypeOfBridge, List<String>> getMoveLog() {
        return moveLog;
    }
}
