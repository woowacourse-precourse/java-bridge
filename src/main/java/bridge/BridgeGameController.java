package bridge;

import java.util.List;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start(){
        outputView.printStartMsg();
        outputView.printRequestLenOfBridge();

        int size = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        outputView.printChooseMove();
        String move = inputView.readMoving();
        bridgeGame.move(move);
        outputView.printMap(bridgeGame.toString());
    }
}
