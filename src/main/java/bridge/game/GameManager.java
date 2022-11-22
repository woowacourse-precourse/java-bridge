package bridge.game;

import bridge.BridgeMaker;
import bridge.etc.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    private GameState gameState = GameState.CONTINUE;

    public void game() {
        outputView.printStartMessage();
        initBridge();
        moveBridge();
    }

    private void initBridge() {
        System.out.println();
        outputView.printInputBridgeLengthMessage();
        Integer size = inputView.readBridgeSize();

        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));

        bridgeGame = new BridgeGame(bridge);
    }

    private void moveBridge() {
        while (gameState.equals(GameState.CONTINUE)) {
            outputView.printInputMoveDirectionMessage();
            String command = inputView.readMoving();
            gameState = bridgeGame.move(command);
            outputView.printMap(bridgeGame.getBridge(), gameState);
        }
    }
}
