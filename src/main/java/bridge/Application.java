package bridge;

public class Application {
    private final InputView input;
    private final OutputView output;
    private int tryCount = 0;
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
        tryCount++;
        return createBridge(input.readBridgeSize());
    }

    private BridgeGame generateBridgeGame(Bridge bridge) {
        return new BridgeGame(bridge);
    }

    private Result nextPanels(BridgeGame game) {
        Result result = game.move(input.readMoving());
        while(result.equals(Result.SAME)){
            result = game.move(input.readMoving());
        }
        return result;
    }

    public static void main(String[] args) {
        Application app = new Application();
        Bridge bridge = app.gameStart();
        BridgeGame game = new BridgeGame(bridge);
        Result result = app.nextPanels(game);

    }

}
