package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private InputView inputView = new InputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private OutputView outputView = new OutputView();
    private String success = "실패";
    private List<String> bridge = new ArrayList<>();

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        gameStart();
        while (bridgeGame.isGameContinue() && bridgeGame.getCurrentCount() < bridge.size()) {
            moveBridge();
        }
        if (bridge.size() == bridgeGame.getUp().size()) {
            success = "성공";
        }
        outputView.printResult(bridgeGame, success);
    }

    public void gameStart() {
        try {
            int size = inputView.readBridgeSize();
            System.out.println();
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            bridge = bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException e) {
            gameStart();
        }
    }

    public void moveBridge() {
        try {
            String move = inputView.readMoving();
            bridgeGame.move(move, bridge);
            outputView.printMap(bridgeGame);
            if (!bridgeGame.isGameContinue()) {
                reStart();
            }
        } catch (IllegalArgumentException e) {
            moveBridge();
        }
    }

    public void reStart() {
        try {
            if (inputView.readGameCommand().contentEquals("R")) {
                bridgeGame.retry();
            }
        } catch (IllegalArgumentException e) {
            reStart();
        }
    }
}
