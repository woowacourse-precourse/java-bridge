package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGreeting();
        BridgeGame bridgeGame = initialize(inputView, outputView);

        outputView.printMoveInputMessage();
        String direction = inputView.readMoving();

        bridgeGame.move(direction);
    }

    private static BridgeGame initialize(InputView inputView, OutputView outputView) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        do {
            outputView.printBridgeSizeInputMessage();
            try {
                return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
