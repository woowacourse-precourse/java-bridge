package bridge;

public class BridgeController {

    InputView inputView;
    OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStartStatement();
    }

    public BridgeBluePrint drawBluePrint() {
        while (true) {
            try {
                int number = inputView.readBridgeSize();
                return new BridgeBluePrint(number);
            } catch (IllegalStateException e) {
                outputView.printError(e);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

}
