package bridge;

public class Controller {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;

    public Controller(InputView inputView, OutputView outputView, BridgeRandomNumberGenerator bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = new BridgeMaker(bridgeMaker);
    }

}
