package bridge;

public class Application {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        outputView.printStartGame();
        outputView.printInputBridgeLength();
        int bridgeSize;
        try {
            bridgeSize = inputView.readBridgeSize();
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
