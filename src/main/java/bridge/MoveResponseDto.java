package bridge;

public class MoveResponseDto {
    private String selectedBridge;
    private Result result;
    private boolean allCorrect;
    private int attemptCount;

    public MoveResponseDto(String selectedBridge, Result result, int attemptCount) {
        this.selectedBridge = selectedBridge;
        this.result = result;
        this.allCorrect = Boolean.FALSE;
        this.attemptCount = attemptCount;
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

    public boolean isAllCorrect() {
        return allCorrect;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
