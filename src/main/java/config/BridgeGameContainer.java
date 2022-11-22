package config;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.presentation.BridgeGameSystem;
import bridge.presentation.view.InputView;
import bridge.presentation.view.OutputView;

public class BridgeGameContainer {

    private static BridgeGameContainer bridgeGameContainer;

    private BridgeGameContainer() {
    }

    public static BridgeGameContainer getInstance() {
        if (bridgeGameContainer == null) {
            bridgeGameContainer = new BridgeGameContainer();
        }
        return bridgeGameContainer;
    }

    public BridgeGameSystem bridgeGameSystem() {
        return new BridgeGameSystem(bridgeMaker(), inputView(), outputView());
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
