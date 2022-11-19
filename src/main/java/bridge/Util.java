package bridge;

public class Util {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public String determineWhereToGo() {
        outputView.printWhereToGoInputRequest();
       return inputView.readMoving();
    }

    public int determineBridgeSize() {
        outputView.printBridgeLengthInputRequest();
        return inputView.readBridgeSize();
    }

}
