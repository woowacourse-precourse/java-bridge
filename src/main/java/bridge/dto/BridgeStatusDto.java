package bridge.dto;

public class BridgeStatusDto {
    private final String bridge;
    private final String successOrFailure;
    private final int count;

    public BridgeStatusDto(String bridge, String successOrFailure, int count) {
        this.bridge = bridge;
        this.successOrFailure = successOrFailure;
        this.count = count;
    }

    public String getBridge() {
        return bridge;
    }

    public String getSuccessOrFailure() {
        return successOrFailure;
    }

    public int getCount() {
        return count;
    }
}
