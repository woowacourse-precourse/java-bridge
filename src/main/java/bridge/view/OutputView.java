package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResult;
import bridge.constant.MovingResult;
import bridge.constant.OutputMessage;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(BridgeGameResult bridgeGameResult) {
        String upSideIndex = makeIndex(bridgeGameResult.getUpBridge());
        String downSideIndex = makeIndex(bridgeGameResult.getDownBridge());
        System.out.println(upSideIndex);
        System.out.println(downSideIndex);
    }

    public void printResult(BridgeGameResult bridgeGameResult, BridgeGame bridgeGame) {
        System.out.println(OutputMessage.GAME_RESULT.getMessage());
        printMap(bridgeGameResult);
        System.out.println(OutputMessage.GAME_SUCCESS_OR_FAILURE.getMessage() + getSuccessPhrase(
                bridgeGameResult.isSuccess()));
        System.out.println(OutputMessage.TRY_COUNT.getMessage() + bridgeGame.getTryCount());
    }

    public String getSuccessPhrase(boolean comparisonResult) {
        return MovingResult.fromComparison(comparisonResult)
                .getPhrase();
    }

    public String makeIndex(List<String> bridge) {
        return OutputMessage.INDEX_START.getMessage() + String.join(
                OutputMessage.INDEX_DELIMITER.getMessage(), bridge) + OutputMessage.INDEX_END.getMessage();
    }
}
