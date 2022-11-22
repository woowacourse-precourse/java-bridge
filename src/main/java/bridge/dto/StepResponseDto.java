package bridge.dto;

import static bridge.controller.BridgeGame.FAIL;
import static bridge.controller.BridgeGame.SUCCESS;

import bridge.model.Score;
import java.util.List;

public class StepResponseDto {

    private List<String> step;
    private int retryCount;
    private boolean isSuccess;
    private boolean isFinal = FAIL;

    public StepResponseDto(final Score score) {
        this.step = score.getUserStep();
        this.retryCount = score.getRepetition();
        this.isSuccess = SUCCESS;
        this.isFinal = SUCCESS;
    }

    public StepResponseDto(final Score score, final boolean isSuccess) {
        this.step = score.getUserStep();
        this.retryCount = score.getRepetition();
        this.isSuccess = isSuccess;
    }

    public List<String> getStep() {
        return step;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
