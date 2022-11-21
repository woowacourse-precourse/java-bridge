package bridge.engine.state;

import bridge.engine.BridgeGame;
import bridge.engine.reporter.BridgeResult;
import bridge.engine.generator.BridgeMaker;
import bridge.engine.generator.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeStartState implements BridgeState {

    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;

    public BridgeStartState(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame.getBridge().addAll(bridge);

        bridgeGame.setState(bridgeGame.getMoveState());
    }

    @Override
    public boolean move(String direction) {
        return true;
    }

    @Override
    public boolean retry(String command) {
        return false;
    }

    @Override
    public BridgeResult end() {
        return null;
    }
}
