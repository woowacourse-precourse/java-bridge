package bridge.engine.state;

import bridge.engine.BridgeDirection;
import bridge.engine.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeMoveState implements BridgeState {

    private BridgeGame bridgeGame;
    private OutputView outputView;
    private InputView inputView;

    public BridgeMoveState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    @Override
    public void start() {

    }

    @Override
    public boolean move() {
        boolean isCanBeCross = false;

        outputView.printInputBridge();
        BridgeDirection.valueOf(inputView.readMoving());

        //TODO:: 건널 수 있는지 확인 절차
        if (!isCanBeCross) {
            bridgeGame.setState(bridgeGame.getRetryState());
        }
        outputView.printMap();
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
