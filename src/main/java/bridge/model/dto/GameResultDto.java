package bridge.model.dto;

import bridge.model.domain.SuccessOrFail;
import java.util.List;

public class GameResultDto {

    private final List<Integer> bridgeMap;
    private final SuccessOrFail successOrFail;
    private final int retryCount;

    public GameResultDto(List<Integer> bridgeMap, SuccessOrFail successOrFail, int retryCount) {
        this.bridgeMap = bridgeMap;
        this.successOrFail = successOrFail;
        this.retryCount = retryCount;
    }

    public List<Integer> getBridgeMap() {
        return bridgeMap;
    }

    public SuccessOrFail getSuccessOrFail() {
        return successOrFail;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
