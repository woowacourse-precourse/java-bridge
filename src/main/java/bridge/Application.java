package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    /**
     * 메인스레드에서 생성한 {@link BridgeMaker}, {@link InputView}, {@link OutputView}를 주입하여 컨트롤러 동작
     * @param args
     */
    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeMaker, inputView, outputView);
        bridgeGameController.run();
    }

}
