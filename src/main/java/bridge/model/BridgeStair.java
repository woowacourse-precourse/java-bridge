package bridge.model;

import bridge.constant.GameConstants;
import bridge.utils.BridgeGameResultStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BridgeStair {
    private final List<BridgeGameResultStatus> currentResult;
    private final int bridgeSize;

    public BridgeStair(int bridgeSize) {
        currentResult = new ArrayList<>();
        this.bridgeSize = bridgeSize;
    }

    public void addResult(BridgeGameResultStatus stepResult) {
        currentResult.add(stepResult);
    }

    public boolean isGameSuccess() {
        return currentResult.size() == bridgeSize
                && currentResult.get(currentResult.size() - 1).equals(BridgeGameResultStatus.CORRECT);
    }

    public StringJoiner getCurrentResult() {
        StringJoiner bridgeResultMessage = new StringJoiner(GameConstants.resultDelimiter, GameConstants.resultPrefix, GameConstants.resultPostfix);
        for (BridgeGameResultStatus result : currentResult) {
            bridgeResultMessage.add(result.getResultStatus());
        }
        return bridgeResultMessage;
    }

    public void clearResult() {
        currentResult.clear();
    }
}
