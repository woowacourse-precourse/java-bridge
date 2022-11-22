package bridge.dto;

import java.util.Objects;

public class SuccessOrFailureDto {
    private final String bridge;
    private final String successOrFailure;

    public SuccessOrFailureDto(String bridge, String successOrFailure) {
        this.bridge = bridge;
        this.successOrFailure = successOrFailure;
    }

    public String getBridge() {
        return bridge;
    }

    public String getSuccessOrFailure() {
        return successOrFailure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuccessOrFailureDto that = (SuccessOrFailureDto) o;
        return Objects.equals(bridge, that.bridge) && Objects.equals(successOrFailure, that.successOrFailure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge, successOrFailure);
    }

    @Override
    public String toString() {
        return "SuccessOrFailureDto{" +
                "bridge='" + bridge + '\'' +
                ", successOrFailure='" + successOrFailure + '\'' +
                '}';
    }
}
