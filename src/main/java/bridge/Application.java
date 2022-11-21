package bridge;

import bridge.views.InputView;
import bridge.views.OutputView;

public class Application {

    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame(inputView, outputView);
        bridgeGame.start();
    }
}
