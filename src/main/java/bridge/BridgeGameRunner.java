package bridge;

import java.util.List;

public class BridgeGameRunner {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameRunner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void runGame() {
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        this.bridgeGame = new BridgeGame(bridge);
        loopRun(false, true);
        String success = "실패";
        if (bridgeGame.getSuccess()) {
            success = "성공";
        }
        outputView.printResult(bridgeGame.getPath(), success, bridgeGame.getTryCount());
    }

    public void loopRun(boolean isEnd, boolean retryOption) {
        while (!isEnd && retryOption) {
            outputView.printMap(bridgeGame.move(inputView.readMoving()));
            if (bridgeGame.isFail()) {
                retryOption = bridgeGame.retry(inputView.readGameCommand());
            }
            isEnd = bridgeGame.isSuccess();
        }
    }
}
