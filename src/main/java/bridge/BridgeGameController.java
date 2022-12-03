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
        outputView.printBridgeSizeMessage();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return new BridgeGame(bridge);
    }

    public void run(){
        outputView.printStartGameMessage();
        BridgeGame bridgeGame = makeBridgeGame();
        play(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    public void play(BridgeGame bridgeGame) {
        while (bridgeGame.isMatch() && !bridgeGame.isEnd()){
            outputView.printMovingMessage();
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
            if (!bridgeGame.isMatch()){
                outputView.printRetryMessage();
                bridgeGame.retry(inputView.readGameCommand());
            }
        }
    }

}
