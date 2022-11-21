package bridge;

import bridge.exception.ValidException;
import bridge.service.BridgeGame;
import bridge.service.BridgeInit;
import bridge.service.BridgeMaker;
import bridge.service.BridgeService;
import bridge.view.BridgePainting;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeInit bridgeInit = new BridgeInit(
                new InputView(new ValidException()),
                new BridgeMaker(new BridgeRandomNumberGenerator()));
        BridgeGame bridgeGame = new BridgeGame(bridgeInit, new BridgePainting());
        BridgeService bridgeService = new BridgeService(new OutputView(), bridgeGame);

        bridgeGame.gameInit();
        bridgeService.start();
    }
}
