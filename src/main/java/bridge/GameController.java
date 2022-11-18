package bridge;

public class GameController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void start() {
        output.printStart();
        Bridge randomBridge = makeBridge();
        output.printMove();
        String inputMove = input.readMoving();

        int tryCount = 0;
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        bridgeGame.move(inputMove, tryCount);
    }

    private Bridge makeBridge() {
        output.printInputBridgeSize();
        while (true) {
            try {
                int bridgeSize = input.readBridgeSize();
                return new Bridge(maker.makeBridge(bridgeSize));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
