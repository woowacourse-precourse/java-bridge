package bridge;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    
    public BridgeGameController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }


}
