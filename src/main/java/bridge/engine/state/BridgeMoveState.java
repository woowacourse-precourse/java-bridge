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
        bridgeGame.setTryCount(bridgeGame.getTryCount() + 1);

        if (!isBridgeCorrect(bridgeGame.getBridge(), bridgeGame.getUserDirection())) {
            bridgeGame.setState(bridgeGame.getRetryState());
            isSuccess = false;
        }

        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserDirection());
        return isSuccess;
    }

    private boolean isBridgeCorrect(List<String> bridge, List<String> userDirection) {
        for (int i = 0; i < userDirection.size() && i < bridge.size(); ++i) {
            if (!(bridge.get(i).equals(userDirection.get(i)))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean retry() {
        return false;
    }

    @Override
    public void end() {

    }
}
