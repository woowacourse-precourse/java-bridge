package bridge;

import java.util.List;

public class GameLauncher {
    public InputView playerInput = new InputView();
    public OutputView printer = new OutputView();

    public List<String> bridgeManager() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(playerInput.readBridgeSize());
    }

    public void startGame() {
        printer.printStartMessage();
        BridgeGame bridgeGame = new BridgeGame(bridgeManager());
        bridgeGame.runGame();
    }
}
