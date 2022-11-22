package bridge.controller;// @ author ninaaano

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.MapMaker;
import bridge.model.BridgeGame;
import bridge.view.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private List<String> bridge = new ArrayList<>();
    BridgeGame bridgeGame;
    MapMaker mapMaker;
    private int count = 0;
    private boolean gameResult = true;

    public BridgeGameController() {
        try {
            OutputView.showStartMessage();
            createBridge();
            moveBridge();
            printResult();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void bridgeGameSet() {
        bridgeGame = new BridgeGame(bridge);
    }

    private void createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.showInputBridgeLength();
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        System.out.println();
    }

    private void moveBridge() {
        do {
            bridgeGameSet();
            count++;
        } while (gameProceeding());
    }

    private boolean gameProceeding() {
        mapMaker = new MapMaker(bridge);
        return extracted();
    }

    private boolean extracted() {
        while (true) {
            OutputView.showInputMove();
            boolean proceeding = bridgeGame.move(InputView.readMoving());
            addMap(proceeding);
            if (extracted(proceeding)) return bridgeGame.retry(InputView.readGameCommand());
            if (bridgeGame.isEscape()) {
                return (gameResult = false);
            }
        }
    }

    private boolean extracted(boolean proceeding) {
        if (!proceeding) {
            OutputView.showGameStatus();
            return true;
        }
        return false;
    }

    private void addMap(boolean result) {
        mapMaker.addMap(result);
        OutputView.printMap(mapMaker);
    }

    private void printResult() {
        OutputView.printResult(mapMaker, gameResult, count);
    }
}
