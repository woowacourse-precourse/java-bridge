package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.BridgeMaker;
import bridge.engine.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeStartState implements BridgeState {

    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private OutputView outputView;
    private InputView inputView;

    public BridgeStartState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    @Override
    public void start() {
        outputView.printStartMessage();
        outputView.printNewLine();

        outputView.printInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.getBridge().addAll(bridge);
        System.out.println(bridgeGame.getBridge());

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
    public void end() {}
}
