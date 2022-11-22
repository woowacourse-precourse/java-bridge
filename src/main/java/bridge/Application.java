package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame, inputView, outputView);

    public static void main(String[] args) {
        outputView.printIntro();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        List<String> route = new ArrayList<>();
        List<Integer> gameRestartCount = new ArrayList<>(List.of(1));
        bridgeGameProcessor.start(bridge, route, gameRestartCount);

        outputView.printResult(bridge, route, gameRestartCount);
    }
}
