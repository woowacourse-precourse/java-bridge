package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

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
        boolean isSuccess = true;
        outputView.printInputBridge();
        bridgeGame.getUserDirection().add(inputView.readMoving());

//        if (isCanCross(bridgeGame.getBridge(), bridgeGame.getUserDirection())) {
//            bridgeGame.setState(bridgeGame.getRetryState());
//            isSuccess = false;
//        }

        outputView.printMap();
        return isSuccess;
    }

    @Override
    public boolean retry() {
        return false;
    }

    @Override
    public void end() {

    }
}
