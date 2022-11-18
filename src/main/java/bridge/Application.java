package bridge;

public class Application {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    private void play() {
        bridgeGame=bridgeGameStart();
    }
    private BridgeGame bridgeGameStart() {
        int bridgeSize= inputBridgeSize();
        BridgeGame bridgeGame=new BridgeGame(bridgeSize);
        return bridgeGame;
    }
    private int inputBridgeSize() {
        return inputView.readBridgeSize();
    }
}
