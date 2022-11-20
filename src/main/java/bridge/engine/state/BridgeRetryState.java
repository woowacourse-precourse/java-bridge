package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeRetryState implements BridgeState {

    private BridgeGame bridgeGame;
    private OutputView outputView;
    private InputView inputView;

    public BridgeRetryState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
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
            bridgeGame.setState(bridgeGame.getMoveState());
        }

        return isRetry;
    }

    @Override
    public void end() {}
}
