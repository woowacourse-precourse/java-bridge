package bridge;

import bridge.game.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ApplicationContext {
    public GameProcess process() {
        return new GameProcess(bridgeGame(), inputView(), outputView());
    }

    public BridgeGame bridgeGame() {
        return new BridgeGame(bridgeMaker());
    }

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
