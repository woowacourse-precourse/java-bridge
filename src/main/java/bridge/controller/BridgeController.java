package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        List<String> bridge = gameStart();

        while (bridgeGame.getCurrentCount() < bridge.size()) {
            moveBridge(bridge);
        }
    }

    public List<String> gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputView.readBridgeSize();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        return bridge;
    }

    public void moveBridge(List<String> bridge) {
        String move = inputView.readMoving();
        bridgeGame.move(move, bridge);
        OutputView outputView = new OutputView();
        outputView.printMap(bridgeGame);
    }
}
