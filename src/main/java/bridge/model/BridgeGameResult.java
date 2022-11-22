package bridge.model;

import bridge.constant.GameConstants;
import bridge.dto.FinalResultDto;
import bridge.utils.BridgeGameResultStatus;
import bridge.utils.BridgeStep;

public class BridgeGameResult {
    private final BridgeStair upResult;
    private final BridgeStair downResult;

    public BridgeGameResult(int bridgeSize) {
        upResult = new BridgeStair(bridgeSize);
        downResult = new BridgeStair(bridgeSize);
    }

    public void addResult(BridgeGameResultStatus stepResult, String direction) {
        if (direction.equals(BridgeStep.UP.getStep())) {
            upResult.addResult(stepResult);
            downResult.addResult(BridgeGameResultStatus.EMPTY);
            return;
        }
        downResult.addResult(stepResult);
        upResult.addResult(BridgeGameResultStatus.EMPTY);
    }

    public boolean isGameSuccess() {
        return upResult.isGameSuccess() || downResult.isGameSuccess();
    }

    public StringBuffer getCurrentResult() {
        StringBuffer mapResult = new StringBuffer();
        mapResult.append(upResult.getCurrentResult()).append("\n").append(downResult.getCurrentResult()).append("\n");
        return mapResult;
    }

    public StringBuffer getFinalResult(boolean isGameSuccess, int gameTryCount) {
        StringBuffer result = new StringBuffer();
        result.append(GameConstants.finalResultMessage);
        result.append(getCurrentResult());
        StringBuffer finalResult = new FinalResultDto(isGameSuccess, gameTryCount).getFinalResult();
        result.append(finalResult);
        return result;
    }

    public void clearResult() {
        upResult.clearResult();
        downResult.clearResult();
    }
}