package bridge;

public class MoveResponseDto {
    private String selectedBridge;
    private Result result;

    public MoveResponseDto(String selectedBridge, Result result) {
        this.selectedBridge = selectedBridge;
        this.result = result;
    }

    public String getSelectedBridge() {
        return selectedBridge;
    }

    public Result getResult() {
        return this.result;
    }

    public boolean getResultBooleanType() {
        return result.getValue();
    }
}
