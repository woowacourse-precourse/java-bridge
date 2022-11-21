package bridge;

public class MoveResponseDto {
    private String selectedBridge;
    private boolean result;

    public MoveResponseDto(String selectedBridge, boolean result) {
        this.selectedBridge = selectedBridge;
        this.result = result;
    }

    public String getSelectedBridge() {
        return selectedBridge;
    }

    public boolean getResult() {
        return result;
    }
}
