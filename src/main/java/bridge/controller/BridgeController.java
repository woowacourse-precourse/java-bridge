package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final StringBuilder upsideResult = new StringBuilder("[]");
    private final StringBuilder downsideResult = new StringBuilder("[]");
    private boolean BRIDGE_GAME_RESULT = true;
    public void run() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        OutputView.printGameStartMessage();
        int bridgeSize = InputView.inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridgeMakeResult = bridgeMaker.makeBridge(bridgeSize);
        BridgeResult bridgeResult = new BridgeResult(upsideResult, downsideResult);
        BridgeGame bridgeGame = new BridgeGame(bridgeMakeResult, 1);

        System.out.println("다리 결과" + bridgeMakeResult);
        for (int i = 0; i < bridgeSize; i++) {
            bridgeResult.replaceCloseBracket(i);
            String moveSide = InputView.inputMoving();
            if (bridgeGame.move(moveSide, i)) {
                bridgeResult.moveSuccess(bridgeGame,moveSide, i);
                OutputView.printMap(bridgeResult);
                continue;
            }
            if (!bridgeGame.move(moveSide, i)) {
                bridgeResult.moveFail(bridgeGame,moveSide, i);
                OutputView.printMap(bridgeResult);
                BRIDGE_GAME_RESULT = bridgeGame.retry();
            }
            if (BRIDGE_GAME_RESULT) {
                bridgeGame.retryCount();
                bridgeResult.goBackBeforeOneStep(i);
                i--;
            }
            if (!BRIDGE_GAME_RESULT) {
                break;
            }
        }
        OutputView.printBridgeResult(bridgeResult,BRIDGE_GAME_RESULT, bridgeGame.getTryCount());
    }
}
