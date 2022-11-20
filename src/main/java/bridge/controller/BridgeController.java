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
        OutputView.printGameStartMessage();
        int bridgeSize = InputView.inputBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridgeMakeResult = bridgeMaker.makeBridge(bridgeSize);
        BridgeResult bridgeResult = new BridgeResult(upsideResult, downsideResult);
        BridgeGame bridgeGame = new BridgeGame(bridgeMakeResult, 1);

        System.out.println("다리 결과" + bridgeMakeResult);
        for (int bridgeIndex = 0; bridgeIndex < bridgeSize; bridgeIndex++) {
            bridgeResult.replaceCloseBracket(bridgeIndex);
            String moveSide = InputView.inputMoving();
            if (bridgeGame.move(moveSide, bridgeIndex)) {
                bridgeResult.moveSuccess(bridgeGame,moveSide, bridgeIndex);
                OutputView.printMap(bridgeResult);
                continue;
            }
            if (!bridgeGame.move(moveSide, bridgeIndex)) {
                bridgeResult.moveFail(bridgeGame,moveSide, bridgeIndex);
                OutputView.printMap(bridgeResult);
                BRIDGE_GAME_RESULT = bridgeGame.retry();
            }
            if (BRIDGE_GAME_RESULT) {
                bridgeGame.retryCount();
                bridgeResult.goBackBeforeOneStep(bridgeIndex);
                bridgeIndex--;
            }
            if (!BRIDGE_GAME_RESULT) {
                break;
            }
        }
        OutputView.printBridgeResult(bridgeResult,BRIDGE_GAME_RESULT, bridgeGame.getTryCount());
    }
    /*
    1. 다리 길이 입력
    2. for
    3. 이동할 칸 선택
    실패시 재시도 여부
    4. 게임 결과 출
     */

}
