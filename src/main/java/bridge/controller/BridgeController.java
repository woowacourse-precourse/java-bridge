package bridge.controller;

import bridge.*;

import java.util.List;

public class BridgeController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame;

    public void startGame() {
        List<String> bridge;
        int count;

        outputView.printStartingPhrase();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);

        while (true) {
            bridgeGame.resetUserMoving();
            System.out.println(bridgeGame.getBridge());
            count = startMove();

            if (bridgeGame.isSuccess()) {
                outputView.printResult(bridgeGame.getUserMoving(),"성공",count);
                break;
            }
            if (bridgeGame.retry(inputView.readGameCommand()) == false) {
                outputView.printResult(bridgeGame.getUserMoving(),"실패",count);
                break;
            }
        }
    }

    public int startMove() {
        int count=0;

        while (true) {
            count++;

            if (bridgeGame.move(inputView.readMoving()) == false) {
                outputView.printMap(bridgeGame.getUserMoving());
                break;
            }
            if (bridgeGame.isEndOfBridge() == true) {
                outputView.printMap(bridgeGame.getUserMoving());
                break;
            }
            outputView.printMap(bridgeGame.getUserMoving());
        }

        return count - 1;
    }
}
