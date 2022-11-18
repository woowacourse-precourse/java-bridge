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
        while (bridgeGame.isNotDone()) {
            outputView.printRequestMoveSideComment();
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.nowUserMapState());

            if (bridgeGame.isFail()) {
                outputView.printRequestRetryComment();
                String s = inputView.readRetry();
                if (s.equals("R")) {
                    bridgeGame.retry();
                }
            }
        }
        outputView.printResultComment();
        outputView.printMap(bridgeGame.nowUserMapState());
        outputView.printResult(bridgeGame.failOrSuccess(), bridgeGame.getTryCount());
    }
}
