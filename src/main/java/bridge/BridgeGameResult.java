package bridge;

import bridge.constant.Constant;
import bridge.domain.BridgeColumn;
import bridge.view.OutputView;

public class BridgeGameResult {
    public void printGameResult(boolean success, int gamePlayCount) {
        new OutputView().printResult(BridgeColumn.getResultMapAsString(), isSuccessAsString(success), gamePlayCount);
    }

    private String isSuccessAsString(boolean success) {
        String resultMessage = Constant.GAME_FAIL;
        if (success) {
            resultMessage = Constant.GAME_SUCCESS;
        }
        return resultMessage;
    }
}
