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

    public void run() {
        // TODO 메서드를 분리하자 / 메서드 길이는 최대 10줄 / else 사용하지 말 것
        OutputView.printStartGame();
        int size = InputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge.toString());

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initMap();

        for (int i = 0; i < size; i++) {
            String answer = bridge.get(i);
            String moving = InputView.readMoving();
            map = bridgeGame.move(answer, moving);
            OutputView.printMap(map);
            if (bridgeGame.isWrongAnswer()) {
                String gameCommand = InputView.readGameCommand();
                if (!bridgeGame.retry(gameCommand)) {
                    result = Constant.FAIL;
                    break;
                }
                i = -1;
            }
            result = Constant.SUCCESS;
        }
        OutputView.printResult(map, result, bridgeGame.countTotalTry());
    }
}
