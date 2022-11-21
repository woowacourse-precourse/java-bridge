package bridge;

import bridge.engine.BridgeGame;
import bridge.engine.reporter.BridgeResult;
import bridge.engine.reporter.BridgeReporter;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameContext {

    private BridgeGame bridgeGame;
    private BridgeReporter reporter;
    private OutputView outputView;
    private InputView inputView;

    public BridgeGameContext(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.reporter = new BridgeReporter();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        start();
        play();
        end();
    }

    private void start() {
        outputView.printStartMessage();
        outputView.printInputBridgeSize();

        int bridgeSize = inputView.readBridgeSize();
        outputView.printNewLine();

        bridgeGame.start(bridgeSize);
    }

    private void play() {
        boolean isMoving = true;

        while (isMoving && bridgeGame.getMoveCount() < bridgeGame.getBridge().size()) {
            outputView.printInputBridge();
            boolean isSuccess = bridgeGame.move(inputView.readMoving());
            outputView.printMap(reporter.reportBridge(bridgeGame.getBridge(), bridgeGame.getUserDirection()));

            if (!isSuccess) {
                isMoving = retry();
            }
        }
    }

    private boolean retry() {
        outputView.printRetryMessage();
        String command = inputView.readGameCommand();

        return bridgeGame.retry(command);
    }

    private void end() {
        BridgeResult result = bridgeGame.end();

        outputView.printResult(result.getResult(), result.getIsSuccess(), result.getTryCount());
    }
}
