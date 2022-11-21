package bridge;

import view.InputView;
import view.OutputView;

public class Application {
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();

    public static void main(String[] args) {
        outputView.printStart();
        play(inputView.readBridgeSize());
    }

    public static void play(int size) {
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = bridgeGame.setBridge(size);
        for (int i = 0; i < size; i++) {
            outputView.printMap(bridgeGame.move(bridge, i, inputView.readMoving()));
        }
    }
}
