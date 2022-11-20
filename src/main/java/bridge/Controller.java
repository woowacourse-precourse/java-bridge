package bridge;

public class Controller {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;

    public Controller(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.outputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void start() {
        outputView.printGameStart();
    }
}
