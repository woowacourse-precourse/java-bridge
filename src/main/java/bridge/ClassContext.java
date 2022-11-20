package bridge;

public class ClassContext {
    private static ClassContext instance;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker;

    private ClassContext() {
    }

    public static ClassContext getInstance() {
        if (ClassContext.instance == null)
            ClassContext.instance = new ClassContext();
        return ClassContext.instance;
    }

    public InputView getInputView() {
        return this.inputView;
    }

    public OutputView getOutputView() {
        return this.outputView;
    }

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return this.bridgeNumberGenerator;
    }

    public BridgeGame bridgeGame() {
        return this.bridgeGame;
    }

    public BridgeMaker bridgeMaker(){
        this.bridgeMaker = new BridgeMaker(this.bridgeNumberGenerator);
        return this.bridgeMaker;
    }

    public void setBridgeNumberGenerator(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
}
