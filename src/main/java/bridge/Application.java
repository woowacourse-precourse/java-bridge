package bridge;
import bridge.InputView;

public class Application {

    private final static OutputView outPutView = new OutputView();
    private final static InputView inPutView = new InputView();
    private final static BridgeGame bridgeGame = new BridgeGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outPutView.printStart();
        run();
    }

    private static void run() {
        try {
            outPutView.printSize();
            int size = inPutView.readBridgeSize();
            bridgeGame.createBridge(size);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] ");
            run();
        }
    }

    private static void running() {
        String checkOX;
        do {
            outPutView.moveUpDown();
            checkOX = bridgeGame.move(inPutView.readMoving());
        } while (bridgeGame.check(checkOX));
    }
}
