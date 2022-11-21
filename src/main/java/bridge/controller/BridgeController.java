package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    public void run() {
        OutputView.printGameStartMessage();
        int bridgeSize = InputView.inputBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridgeMakeResult = bridgeMaker.makeBridge(bridgeSize);
        BridgeResult bridgeResult = new BridgeResult(true);
        boolean gameResult = bridgeResult.getResult();
        BridgeGame bridgeGame = new BridgeGame(bridgeMakeResult, 1);

        System.out.println("다리 결과" + bridgeMakeResult);
        for (int bridgeIndex = 0; bridgeIndex < bridgeSize; bridgeIndex++) {
            OutputView.replaceCloseBracket(bridgeIndex);
            String moveSide = InputView.inputMoving();
            if (bridgeGame.move(moveSide, bridgeIndex)) {
                OutputView.moveSuccess(bridgeGame,moveSide, bridgeIndex);
                OutputView.printMap();
                continue;
            }
            if (!bridgeGame.move(moveSide, bridgeIndex)) {
                OutputView.moveFail(bridgeGame,moveSide, bridgeIndex);
                OutputView.printMap();
                gameResult = bridgeGame.retry();
            }
            if (gameResult) {
                bridgeGame.retryCount();
                OutputView.goBackBeforeOneStep(bridgeIndex);
                bridgeIndex--;
            }
            if (!gameResult) {
                break;
            }
        }
        OutputView.printBridgeResult(gameResult, bridgeGame.getTryCount());
    }
    /*
    1. 다리 길이 입력
    2. for
    3. 이동할 칸 선택
    실패시 재시도 여부
    4. 게임 결과 출
     */

}
