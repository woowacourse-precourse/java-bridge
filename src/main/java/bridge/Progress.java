package bridge;

import bridge.constant.BridgePattern;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Progress {

    private final Map<BridgePattern, List<String>> record;

    private final String EMPTY_VALUE = " ";

    public Progress(int length) {
        this.record = initRecord(length);
    }

    private Map<BridgePattern, List<String>> initRecord(int length) {
        return new EnumMap<>(BridgePattern.class) {{
            for (BridgePattern bridgePattern : BridgePattern.values()) {
                put(bridgePattern, new ArrayList<>(length));
            }
        }};
    }

    public void updateProgress(BridgePattern inputPattern, String symbol) {
        record.forEach((bridgePattern, progress) -> {
            String state = inspectSymbol(inputPattern, bridgePattern, symbol);
            progress.add(state);
        });
    }

    public String inspectSymbol(BridgePattern inputPattern, BridgePattern bridgePattern, String symbol) {
        if (inputPattern == bridgePattern) {
            return symbol;
        }

        return EMPTY_VALUE;
    }
}
