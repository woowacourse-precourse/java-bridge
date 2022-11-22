package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.exeption.Validator;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameLauncher {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameLauncher() {
        this.inputView = new InputView(new Validator());
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame(inputView, outputView);
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void game(){
        giveBridge();

        List<String> result = bridgeGame.startGame();

        outputView.printResult(result);
    }

    private void giveBridge(){
        outputView.printStart();
        int size = inputView.getBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(size);

        bridgeGame.setBridge(bridge);
    }

}
