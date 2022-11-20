package bridge;

public class Application {
    static InputView input = new InputView();
    static OutputView output = new OutputView();
    static BridgeMaker newBridge = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        boolean playing = true;
        output.printGameStart();
        output.printAskBridgeSize();
        BridgeGame newGame = new BridgeGame(newBridge.makeBridge(input.readBridgeSize()));
        output.printAskMovement();
        while (playing) {
            playing = newGame.move(input.readMoving());
            output.printMap(newGame.bridge, newGame.moveResult);
            if (!playing) {
                output.printAskRetry();
                newGame.retry(input.readGameCommand());
            }
        }
    }
}
