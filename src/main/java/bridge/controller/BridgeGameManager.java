package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.Direction;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameManager {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void play() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        makeBridge();
        crossBridge();
        printGameResult();
    }

    private void makeBridge() {
        try {
            int readBridgeSize = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(readBridgeSize);
            bridgeGame = new BridgeGame(bridge);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeBridge();
        }
    }

    private void crossBridge() {
        while (!bridgeGame.isCrossed()) {
            bridgeGame.move(chooseDirection());
            outputView.printRoute(bridgeGame);
            if (bridgeGame.isFailed()) {
                bridgeGame.retry();
            }
        }
    }

    private Direction chooseDirection() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return chooseDirection();
        }
    }

    private void printGameResult() {

    }
}