package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.BridgeMakerController;
import bridge.service.BridgeGameService;
import bridge.service.BridgeMakerService;

public class AppConfig {
    private BridgeGameService bridgeGameService;

    public BridgeMakerController bridgeMakerController() {
        BridgeMakerService bridgeMakerService = bridgeMakerService();
        setBidgeMakerService(bridgeMakerService);
        return new BridgeMakerController(bridgeMakerService, inputView(), outputView());
    }


    public BridgeGameController bridgeGameController() {
        return new BridgeGameController(bridgeGameService, inputView(), outputView());
    }

    public BridgeMakerService bridgeMakerService() {
        return new BridgeMakerService();
    }

    private void setBidgeMakerService(BridgeMakerService bridgeMakerService) {
        bridgeGameService = new BridgeGameService(bridgeMakerService);
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
