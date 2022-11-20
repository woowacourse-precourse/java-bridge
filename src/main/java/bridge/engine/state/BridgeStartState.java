package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeStartState implements BridgeState {

    private BridgeGame bridgeGame;
    private OutputView outputView;
    private InputView inputView;

    public BridgeStartState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    @Override
    public void start() {
        outputView.printStartMessage();
        outputView.printNewLine();

        outputView.printInputBridgeSize();
        int size = inputView.readBridgeSize();

        bridgeGame.setState(bridgeGame.getMoveState());
    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public boolean retry() {
        return false;
    }

    @Override
    public void end() {

    }
}
