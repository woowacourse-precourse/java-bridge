package bridge;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public Controller(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.outputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void start() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
    }

}
