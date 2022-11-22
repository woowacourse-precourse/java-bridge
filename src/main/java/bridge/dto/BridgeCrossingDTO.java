package bridge.dto;

import java.util.List;

public class BridgeCrossingDTO {
    private final List<List<String>> footPrint;
    private final int tryCount;
    private final String crossStatus;

    public BridgeCrossingDTO(List<List<String>> footPrint, int tryCount, String crossStatus) {
        this.footPrint = footPrint;
        this.crossStatus = crossStatus;
        this.tryCount = tryCount;
    }

    public List<List<String>> getFootPrint() {
        return footPrint;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getCrossStatus() {
        return crossStatus;
    }
}
