package bridge;

import bridge.controller.BridgeGame;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeService bridgeService = getBridgeService();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        BridgeGame bridgeGame = new BridgeGame(bridgeService, inputView, outputView);

        bridgeGame.startGame();
    }

    public static BridgeService getBridgeService() {
        return new BridgeService(getBridgeMaker());
    }

    public static BridgeMaker getBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
