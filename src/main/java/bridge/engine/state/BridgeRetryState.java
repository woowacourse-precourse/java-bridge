package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.reporter.BridgeReporter;
import bridge.engine.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeRetryState implements BridgeState {

    private BridgeGame bridgeGame;
    private BridgeReporter reporter;
    private OutputView outputView;
    private InputView inputView;

    public BridgeRetryState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.reporter = new BridgeReporter();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    @Override
    public void start() {
    }

    @Override
    public boolean move() {
        return true;
    }

    @Override
    public boolean retry() {
        outputView.printRetryMessage();
        String command = inputView.readGameCommand();
        boolean isRetry = GameCommand.valueOf(command).isRetry();

        if (isRetry) {
            bridgeGame.getUserDirection().clear();
            bridgeGame.setTryCount(bridgeGame.getTryCount() + 1);
            bridgeGame.setMoveCount(0);
            bridgeGame.setState(bridgeGame.getMoveState());
        }
        return isRetry;
    }

    @Override
    public void end() {
        String bridgeMap = reporter.reportBridge(bridgeGame.getBridge(), bridgeGame.getUserDirection());

        outputView.printResult(bridgeMap, "실패", bridgeGame.getTryCount());
    }
}
