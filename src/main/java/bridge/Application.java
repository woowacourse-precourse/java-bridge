package bridge;

import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.GameStartView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new GameStartView().printStartMessage();
        new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize());

        bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize()));
        outputView.printMap(bridgeGame.move(inputView.readMoving()));

    }
}
