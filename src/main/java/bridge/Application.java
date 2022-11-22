package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView, bridgeMaker);
        bridgeGameController.play();
    }
}
