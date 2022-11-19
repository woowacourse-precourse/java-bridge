package bridge;

public class Application {
    static InputView input = new InputView();
    static OutputView output = new OutputView();
    static BridgeMaker newBridge = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        output.printGameStart();
        output.printAskBridgeSize();
        BridgeGame newGame = new BridgeGame(newBridge.makeBridge(input.readBridgeSize()));
        output.printAskMovement();
        newGame.move(input.readMoving());
        output.printMap(newGame.bridge, newGame.moveResult);
    }
}
