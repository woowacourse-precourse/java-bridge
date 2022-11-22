package bridge;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public BridgeGame makeBridgeGame(){
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return new BridgeGame(bridge);
    }

    public void run(){
        outputView.printStartTitle();
        BridgeGame bridgeGame = makeBridgeGame();
        play(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    public void play(BridgeGame bridgeGame) {
        while (bridgeGame.isMatch() && !bridgeGame.isEnd()){
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
            if (!bridgeGame.isMatch()){
                bridgeGame.retry(inputView.readGameCommand());
            }
        }
    }

}
