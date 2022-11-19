package bridge.controller;

import bridge.*;

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
        int count;

        outputView.printStartingPhrase();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);

        while (true) {
            bridgeGame.resetUserMoving();
            System.out.println(bridgeGame.getBridge());
            count = startMove();

            if (bridgeGame.isSuccess()) {
                outputView.printResult(bridgeGame.getUserMoving(),SUCCESS,count);
                break;
            }
            // 성공 하지도 못했는데 재시작도 안하면 실패
            if (bridgeGame.retry(inputView.readGameCommand()) == false) {
                outputView.printResult(bridgeGame.getUserMoving(),FAILURE,count);
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
