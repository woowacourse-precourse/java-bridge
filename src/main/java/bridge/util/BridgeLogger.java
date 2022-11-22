package bridge.util;

import bridge.domain.BridgeMovement;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeLogger {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String DELIMITER = " | ";
    private static final String NEWLINE = "\n";

    public static String log(Map<BridgeMovement, List<String>> crossingResults) {
        String result = "";
        for (BridgeMovement movement : BridgeMovement.values()) {
            result += toStingFormatMovement(crossingResults.get(movement));
        }
        return result;
    }

    private static String toStingFormatMovement(List<String> resultStatus) {
        return BRIDGE_START + resultStatus.stream().collect(Collectors.joining(DELIMITER)) + BRIDGE_END + NEWLINE;
    }

}
