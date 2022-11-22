package bridge;

public class Application {
    private InputView input;
    private OutputView output;
    private BridgeGame bridgeGame;

    Application() {
        this.input = new InputView();
        this.output = new OutputView();
    }

    private Bridge createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private Bridge gameStart() {
        this.output.printGameStart();
        this.output.printInputLengthRequestMessage();
        return createBridge(input.readBridgeSize());
    }

    private BridgeGame generateBridgeGame(Bridge bridge) {
        return new BridgeGame(bridge);
    }

    private void nextPanelByPlayer() {
    }

    public static void main(String[] args) {
        Application app = new Application();
        Bridge bridge = app.gameStart();
        BridgeGame game = new BridgeGame(bridge);
        game.move(app.input.readMoving());
        // TODO: 프로그램 구현
    }

}
