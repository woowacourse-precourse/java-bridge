package bridge;

import bridge.logic.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.View;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        View view = createView();
        List<String> bridge = createBridge(view);
        BridgeGame bridgeGame = new BridgeGame();

        GameController gameController = new GameController(view, bridge, bridgeGame);
        gameController.play(1, 0);
    }

    private static View createView() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new View(inputView, outputView);
    }

    private static List<String> createBridge(View view) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        view.printStartGame();
        int size = view.readBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

}
