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
    OutputView outputView = new OutputView();
    String success = "실패";

    public void run() {
        List<String> bridge = gameStart();

        while (bridgeGame.isGameContinue() && bridgeGame.getCurrentCount() < bridge.size()) {
            moveBridge(bridge);
        }

        if (bridge.size() == bridgeGame.getUp().size()) {
            success = "성공";
        }

        outputView.printResult(bridgeGame, success);
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
        outputView.printMap(bridgeGame);

        if (!bridgeGame.isGameContinue()) {
            reStart();
        }
    }

    public void reStart() {
        if (inputView.readGameCommand().contentEquals("R")) {
            bridgeGame.retry();
        }
    }
}
