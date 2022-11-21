package bridge.dto;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "BridgeStatusDto{" +
                "bridge='" + bridge + '\'' +
                ", successOrFailure='" + successOrFailure + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BridgeStatusDto that = (BridgeStatusDto) o;
        return count == that.count && Objects.equals(bridge, that.bridge) && Objects.equals(successOrFailure, that.successOrFailure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge, successOrFailure, count);
    }
}
