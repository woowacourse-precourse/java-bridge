package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printGameStartMessage();
        outputView.printBridgeLengthInputMessage();
        int bridgeSize = inputView.readBridgeSize();
    }
}
