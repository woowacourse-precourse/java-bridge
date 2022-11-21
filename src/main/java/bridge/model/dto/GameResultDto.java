package bridge.model.dto;

import bridge.model.domain.SuccessOrFail;

public class GameResultDto {

    private final SuccessOrFail successOrFail;
    private final int retryCount;

    public GameResultDto(SuccessOrFail successOrFail, int retryCount) {
        this.successOrFail = successOrFail;
        this.retryCount = retryCount;
    }


    public SuccessOrFail getSuccessOrFail() {
        return successOrFail;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
