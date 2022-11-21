package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.reporter.BridgeReporter;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeMoveState implements BridgeState {

    private BridgeGame bridgeGame;
    private BridgeReporter reporter;
    private OutputView outputView;
    private InputView inputView;

    public BridgeMoveState(BridgeGame bridgeGame) {
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
        boolean isSuccess = true;
        outputView.printInputBridge();
        bridgeGame.getUserDirection().add(inputView.readMoving());
        bridgeGame.setMoveCount(bridgeGame.getMoveCount() + 1);

        if (!isBridgeCorrect(bridgeGame.getBridge(), bridgeGame.getUserDirection())) {
            bridgeGame.setState(bridgeGame.getRetryState());
            isSuccess = false;
        }
        outputView.printMap(reporter.reportBridge(bridgeGame.getBridge(), bridgeGame.getUserDirection()));
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
        String bridgeMap = reporter.reportBridge(bridgeGame.getBridge(), bridgeGame.getUserDirection());

        outputView.printResult(bridgeMap, "성공", bridgeGame.getTryCount());
    }
}
