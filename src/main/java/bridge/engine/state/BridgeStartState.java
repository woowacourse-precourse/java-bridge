package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.generator.BridgeMaker;
import bridge.engine.generator.BridgeRandomNumberGenerator;
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
        outputView.printInputBridgeSize();

        int bridgeSize = inputView.readBridgeSize();
        outputView.printNewLine();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.getBridge().addAll(bridge);

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
