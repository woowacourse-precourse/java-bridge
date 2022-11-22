package bridge;

import java.util.List;

public class GameLauncher {
    private InputView playerInput = new InputView();
    private OutputView printer = new OutputView();

    private List<String> bridgeManager() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(playerInput.readBridgeSize());
    }

    public void startGame() {
        printer.printStartMessage();
        BridgeGame bridgeGame = new BridgeGame(bridgeManager());
        boolean isSuccess = bridgeGame.runGame();
        printer.printSuccess(isSuccess);
        printer.printRetryCount(bridgeGame.getRetryCount());
    }
}
