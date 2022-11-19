package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeService bridgeService;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeService = new BridgeService(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}
