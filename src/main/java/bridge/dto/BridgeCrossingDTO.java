package bridge.dto;

import java.util.List;

public class BridgeCrossingDTO {
    private final List<List<String>> footPrint;
    private final int tryCount;
    private final boolean crossComplete;

    public BridgeCrossingDTO(List<List<String>> footPrint, int tryCount, boolean crossComplete) {
        this.footPrint = footPrint;
        this.crossComplete = crossComplete;
        this.tryCount = tryCount;
    }

    public List<List<String>> getFootPrint() {
        return footPrint;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isCrossComplete() {
        return crossComplete;
    }
}
