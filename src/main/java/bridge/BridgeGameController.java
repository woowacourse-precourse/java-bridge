package bridge;

public class BridgeGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidator inputValidator = new InputValidator();
    Player player;
    Bridge bridge;
    BridgeGame bridgeGame;

    int bridgeSize;

    BridgeGameController() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        inputView.showStartingMessage();
        this.bridgeSize = inputView.readBridgeSize();
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        this.player = new Player();
        this.bridgeGame = new BridgeGame(bridge, player);
    }

    public void playBridgeGame() {
        boolean gameContinueFlag = true;
        while (gameContinueFlag) {
            gameContinueFlag = bridgeGame.playGame(inputView.readMoving());
            outputView.printMap(bridge);
            if (!gameContinueFlag) {
                gameContinueFlag = bridgeGame.retry(inputView.readGameCommand());
            }
            gameContinueFlag = bridgeGame.ifUserReachedToEndOfTheBridgeReturnFalse(bridgeSize);
        }
        outputView.printResult(player, bridge);
    }
}
