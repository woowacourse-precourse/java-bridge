package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Constant;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        OutputView.printStartGame();
        List<String> bridge = makeBridge();
        String result = startBridgeGame(bridge);
        quitGame(result);
    }

    public List<String> makeBridge() {
        int size = InputView.readBridgeSize();
        OutputView.printBlankLine();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }

    public String startBridgeGame(List<String> bridge) {
        bridgeGame.initMap();
        for (String answer : bridge) {
            String moving = InputView.readMoving();
            OutputView.printMap(bridgeGame.move(answer, moving));
            if (bridgeGame.isWrongAnswer()) {
                return restartGame(bridge);
            }
        }
        return Constant.SUCCESS;
    }

    public String restartGame(List<String> bridge) {
        String gameCommand = InputView.readGameCommand();
        if (bridgeGame.retry(gameCommand)) {
            return startBridgeGame(bridge);
        }
        return Constant.FAIL;
    }

    public void quitGame(String result) {
        int totalTry = bridgeGame.countTotalTry();
        List<List<String>> bridgeMap = bridgeGame.getBridgeMap();
        OutputView.printResult(bridgeMap, result, totalTry);
    }
}
