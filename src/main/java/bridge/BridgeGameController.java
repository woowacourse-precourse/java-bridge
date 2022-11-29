package bridge;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        inputView.showStartingMessage();
        Bridge bridge = getBridge(bridgeMaker);
        Player player = new Player();
        this.bridgeGame = new BridgeGame(bridge, player);
    }

    public void playBridgeGame() {
        boolean gameContinueFlag = true;
        while (gameContinueFlag) {
            gameContinueFlag = playGame();
            outputView.printMap(bridgeGame.getBridge());
            gameContinueFlag = askToRestartOrEnd(gameContinueFlag);
            if (bridgeGame.isUserReachedToEndOfTheBridge(bridgeGame.getBridge().getSize())) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getPlayer(), bridgeGame.getBridge());
    }

    private Bridge getBridge(BridgeMaker bridgeMaker) {
        int bridgeSize = inputView.readBridgeSize();
        try {
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return getBridge(bridgeMaker);
        }
    }

    private boolean playGame() {
        try{
            return bridgeGame.playGame(inputView.readMoving());
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return playGame();
        }
    }

    private boolean askToRestartOrEnd(boolean gameContinueFlag) {
        if (!gameContinueFlag) {
            try {
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
                return askToRestartOrEnd(gameContinueFlag);
            }
        }
        return true;
    }
}
