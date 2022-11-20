package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGreeting();
        BridgeGame bridgeGame = initializeBridgeGame(inputView, outputView);

        outputView.printMoveInputMessage();
        String direction = inputView.readMoving();

        bridgeGame.move(direction);
    }

    private static BridgeGame initializeBridgeGame(InputView inputView, OutputView outputView) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView.printBridgeSizeInputMessage();
        return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }
}
