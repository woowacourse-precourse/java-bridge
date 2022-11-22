package bridge;

public class RetryResponseDto {
    private String selectedBridge;
    private Result result;

    public RetryResponseDto(String selectedBridge, Result result) {
        this.selectedBridge = selectedBridge;
        this.result = result;
    }
}
