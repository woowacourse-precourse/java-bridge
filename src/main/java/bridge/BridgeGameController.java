package bridge;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void play() {
        outputView.printStartTitle();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (bridgeGame.isMovingStatus() && !bridgeGame.isEnd()){
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
            if (!bridgeGame.isMovingStatus()){
                bridgeGame.retry(inputView.readGameCommand());
                System.out.println(bridgeGame.isMovingStatus());
            }
        }
        outputView.printResult(bridgeGame);
    }

}
