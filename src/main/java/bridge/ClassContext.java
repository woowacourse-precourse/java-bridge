package bridge;

public class ClassContext {
    private static ClassContext instance;

    private static InputView inputView;
    private static BridgeGame bridgeGame;
    private static OutputView outputView;
    private static GameLauncher gameLauncher;
    private static BridgeNumberGenerator bridgeNumberGenerator;
    private static BridgeMaker bridgeMaker;

    private ClassContext() {
        inputView = new InputView();
        bridgeGame = new BridgeGame();
        outputView = new OutputView(bridgeGame);
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        gameLauncher = new GameLauncher(inputView, outputView, bridgeGame, bridgeMaker);
    }

    public static ClassContext getInstance() {
        if (ClassContext.instance == null)
            ClassContext.instance = new ClassContext();
        return ClassContext.instance;
    }

    public InputView getInputView() {
        return inputView;
    }

    public BridgeGame getBridgeGame() {
        return bridgeGame;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public BridgeNumberGenerator getBridgeNumberGenerator() {
        return bridgeNumberGenerator;
    }

    public BridgeMaker getBridgeMaker() {
        return bridgeMaker;
    }

    public GameLauncher getGameLauncher() {
        return gameLauncher;
    }

    public void setBridgeNumberGenerator(BridgeNumberGenerator bridgeNumberGenerator) {
        ClassContext.bridgeNumberGenerator = bridgeNumberGenerator;
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        gameLauncher = new GameLauncher(inputView, outputView, bridgeGame, bridgeMaker);
    }
}
