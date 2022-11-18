package controller;

import controller.services.BridgeMaker;
import controller.services.BridgeRandomNumberGenerator;
import controller.services.GamePlay;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeSystem {
    private GamePlay gamePlay;

    public void runGame() {
        OutputView.printRunGameText();

        List<String> bridge = makeBridge();
        gamePlay = new GamePlay(bridge);
        int result = gamePlay.repeatGame();

        printGameResult(result);
    }

    public List<String> makeBridge() {
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return bridgeMaker.makeBridge(bridgeSize);
    }


    public void printGameResult(int result) {
        OutputView.printResultText();
        OutputView.printMap(gamePlay.getRouteMap().getRouteMap());
        OutputView.printResult(result,gamePlay.getCountOfAttempt());
    }
}
