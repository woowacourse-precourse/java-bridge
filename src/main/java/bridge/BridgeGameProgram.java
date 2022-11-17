package bridge;

import java.util.List;

public class BridgeGameProgram {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameProgram() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        outputView.printGameStartComment();
        outputView.printRequestBridgeSizeComment();
        List<String> bridgeMap = bridgeMaker.makeBridge(inputView.readBridgeSize());

        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        outputView.printRequestMoveSideComment();
        bridgeGame.move(inputView.readMoving());
    }
}
