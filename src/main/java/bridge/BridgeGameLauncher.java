package bridge;

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
        outputView.printStart();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        bridgeGame.setBridge(bridge);
        List<String> result = bridgeGame.startGame();

        outputView.printResult(result);
    }
}
