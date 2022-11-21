package bridge.domain.game;

public enum SuccessStep {
    SUCCESS("O", true),
    FAIL("X", false);

    private final String step;
    private final boolean status;

    SuccessStep(String step, boolean status) {
        this.step = step;
        this.status = status;
    }

    public String getStep() {
        return step;
    }

    public boolean getStatus() {
        return status;
    }

    public static SuccessStep compareStep(String answer, String step){
        if (step.equals(answer)){
            return SUCCESS;
        }
        return FAIL;
    }


}
