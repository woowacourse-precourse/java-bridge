package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    private static void gameStart() {
        OutputView outputView = new OutputView();
        outputView.printStartMessage();
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
    }
}
