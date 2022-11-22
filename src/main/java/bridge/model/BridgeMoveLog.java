package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class BridgeMoveLog {

    private final Map<BridgeType, List<String>> moveLog;

    private static final String DEFAULT_STATUS = " ";

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

    public void writeLog(BridgeType selectBridgeType, String safeStatus) {

        moveLog.forEach((bridgeType, log) -> {
            String status = judgeStatus(bridgeType, selectBridgeType, safeStatus);
            log.add(status);
        });
    }

    private String judgeStatus(BridgeType bridgeType, BridgeType selectBridgeType, String safeStatus) {
        if (bridgeType == selectBridgeType) {
            return safeStatus;
        }

        return DEFAULT_STATUS;
    }

    public void resetLog() {
        for (List<String> log : moveLog.values()) {
            log.clear();
        }
    }

    public Map<BridgeType, List<String>> getMoveLog() {
        return Collections.unmodifiableMap(moveLog);
    }
}
