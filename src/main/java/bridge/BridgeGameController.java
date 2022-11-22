package bridge;

public class BridgeGameController {

    private final BridgeGameView bridgeGameView = new BridgeGameView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

}
