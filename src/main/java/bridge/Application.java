package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameController gameController = new GameController(bridgeMaker, inputView, outputView);
        gameController.playGame();
    }
}
