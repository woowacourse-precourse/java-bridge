package bridge.model;

import java.util.List;

public class Result {

    private List<Step> steps;
    private boolean isSuccess;
    private int trial;

    public Result() {
        this.isSuccess = false;
        this.trial = 1;
    }

    public List<Step> getSteps() {
        return this.steps;
    }

    public String getIsSuccess() {
        if (this.isSuccess) {
            return "성공";
        }
        return "실패";
    }

    public int getTrial() {
        return this.trial;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void clear() {
        this.steps.clear();
        this.isSuccess = false;
        this.trial++;
    }

}
