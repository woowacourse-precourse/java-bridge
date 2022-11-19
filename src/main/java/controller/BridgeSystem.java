package controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import controller.services.GamePlay;
import model.GameResult;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeSystem {
    private GamePlay gamePlay;
    private GameResult gameResult;

    public void runGame() {
        OutputView.printRunGameText();

        gamePlay = new GamePlay(initializeBridge(InputView.readBridgeSize()));

        gameResult = gamePlay.playGame();
        OutputView.printGameResult(gameResult);
    }

    public List<String> initializeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
