package bridge.controller;

import bridge.*;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final String SUCCESS = "성공";
    private final String FAILURE = "실패";
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame;

    public void startGame() {
        List<String> bridge;

        outputView.printStartingPhrase();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        //실행 예시와 맞추기 위해 한 칸 띄워준다.
        System.out.println();
        bridgeGame = new BridgeGame(bridge);

        proceedBridgeGame();
    }

    public void proceedBridgeGame() {
        while (true) {
            bridgeGame.resetUserMoving();
            bridgeGame.addAttemptCount();
            //System.out.println(bridgeGame.getBridge());
            startMove();

            if (proceedEndOfGame()) break;
        }
    }

    public boolean proceedEndOfGame() {
        if (bridgeGame.isSuccess()) {
            outputView.printResult(bridgeGame.getUserMoving(), SUCCESS, bridgeGame.getAttemptCount());
            return true;
        }
        // 성공 하지도 못했는데 재시작도 안하면 실패
        if (bridgeGame.retry(inputView.readGameCommand()) == false) {
            outputView.printResult(bridgeGame.getUserMoving(), FAILURE, bridgeGame.getAttemptCount());
            return true;
        }
        return false;
    }

    public void startMove() {
        while (true) {
            if (bridgeGame.move(inputView.readMoving()) == false || bridgeGame.isEndOfBridge() == true) {
                outputView.printMap(bridgeGame.getUserMoving());
                break;
            }
            outputView.printMap(bridgeGame.getUserMoving());
        }
    }
}
