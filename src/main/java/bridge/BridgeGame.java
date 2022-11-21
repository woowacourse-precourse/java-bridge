package bridge;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        System.out.println("게임 시작");
        int bridgeSize = inputView.readBridgeSize();
    }

    public void move() {
    }

    public void retry() {
    }
}
