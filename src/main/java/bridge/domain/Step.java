package bridge.domain;

public enum Step {
    UPPER_STEP("U", 1),
    LOWER_STEP("D", 0);

    private String stepTxt;
    private int stepNumber;

    Step(String stepTxt, int stepNumber) {
        this.stepTxt = stepTxt;
        this.stepNumber = stepNumber;
    }

    public String getStepTxt() {
        return stepTxt;
    }

    public int getStepNumber() {
        return stepNumber;
    }


    public static Step findByNum(int n){
        for (Step step: Step.values()){
            if(step.stepNumber == n){
                return step;
            }
        }
        throw new IllegalArgumentException();
        //TODO: 0 또는 1로만 가능하게 오류 메세지 출력
    }
}
