package bridge;

public class MoveResponseDto {
    private String selectedBridge;
    private Result result;
    private boolean allCorrect;

    public MoveResponseDto(String selectedBridge, Result result) {
        this.selectedBridge = selectedBridge;
        this.result = result;
        this.allCorrect = Boolean.FALSE;
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

    public void setAllCorrect(boolean allCorrect) {
        this.allCorrect = allCorrect;
    }
}
