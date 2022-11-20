package bridge;

public class BridgeController {
    InputView inputView;
    OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        outputView.printStartStatement();
    }
}
