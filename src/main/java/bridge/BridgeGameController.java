package bridge;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    Bridge bridge;
    Player player;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        inputView.showStartingMessage();
        this.bridge = getBridge(bridgeMaker);
        this.player = new Player();
        this.bridgeGame = new BridgeGame(bridge, player);
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

    public void playBridgeGame() {
        boolean gameContinueFlag = true;
        while (gameContinueFlag) {
            gameContinueFlag = playGame(bridgeGame);
            outputView.printMap(bridge);
            gameContinueFlag = AskToRestartOrEnd(bridgeGame, gameContinueFlag);
            if (bridgeGame.ifUserReachedToEndOfTheBridge(bridge.getSize())) {
                break;
            }
        }
        outputView.printResult(player, bridge);
    }

    private boolean playGame(BridgeGame bridgeGame) {
        try{
            return bridgeGame.playGame(inputView.readMoving());
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return playGame(bridgeGame);
        }
    }

    private boolean AskToRestartOrEnd(BridgeGame bridgeGame, boolean gameContinueFlag) {
        if (!gameContinueFlag) {
            try {
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
                return AskToRestartOrEnd(bridgeGame, gameContinueFlag);
            }
        }
        return true;
    }
}
