package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Constant;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private String result;
    private List<List<String>> map;

    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        // TODO 메서드를 분리하자 / 메서드 길이는 최대 10줄 / else 사용하지 말 것
        OutputView.printStartGame();
        makeBridge();
    }

    public void makeBridge() {
        int size = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        startGame(bridge);
    }

    public void startGame(List<String> bridge) {
        bridgeGame.initMap();
        crossBridge(bridge);
    }

    public void crossBridge(List<String> bridge) {
        for (String answer : bridge) {
            String moving = InputView.readMoving();
            map = bridgeGame.move(answer, moving);
            OutputView.printMap(map);
            if (bridgeGame.isWrongAnswer()) {
                String gameCommand = InputView.readGameCommand();
                if (!bridgeGame.retry(gameCommand)) {
                    result = Constant.FAIL;
                    break;
                }
            }
            result = Constant.SUCCESS;
        }
        OutputView.printResult(map, result, bridgeGame.countTotalTry());
    }
}
