package bridge;

public class BridgeApp {

    private static int count = 1;

    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;
    private final InputView inputView;
    private BridgeGame bridgeGame;

    private String move;
    private String command;

    public BridgeApp() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.move = "";
        this.command = "";
    }

    public void startGame() {
        int bridgeSize = -1;
        while (bridgeSize < 3 || bridgeSize > 20) {
            bridgeSize = inputView.readBridgeSize();
        }
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize), bridgeSize);
    }

    public void moveOnBridge() {
        do {
            move = inputView.readMoving();
        } while (move.equals("[ERROR]"));
    }
}
