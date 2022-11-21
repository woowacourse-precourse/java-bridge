package bridge.view;

import bridge.BridgeGame;
import bridge.BridgeGameResult;
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
        System.out.println(OutputMessage.GAME_RESULT.getOutputMessage());
        printMap(bridgeGameResult);
        System.out.println(OutputMessage.GAME_SUCCESS_OR_FAILURE.getOutputMessage() + getSuccessPhrase(
                bridgeGameResult.getSuccess()));
        System.out.println(OutputMessage.TRY_COUNT.getOutputMessage() + bridgeGame.getTryCount());
    }

    public String getSuccessPhrase(boolean comparisonResult) {
        return MovingResult.fromComparison(comparisonResult)
                .getPhrase();
    }

    public String makeIndex(List<String> bridge) {
        return OutputMessage.INDEX_START.getOutputMessage() + String.join(
                OutputMessage.INDEX_DELIMITER.getOutputMessage(), bridge) + OutputMessage.INDEX_END.getOutputMessage();
    }
}
