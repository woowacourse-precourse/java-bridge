package bridge.dto;

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
}
