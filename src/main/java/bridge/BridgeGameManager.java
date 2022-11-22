package bridge;

public class BridgeGameManager {
    private static BridgeGame bridgeGame;
    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final InputView inputView = new InputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private static final OutputView outputView = new OutputView();
    private static final BridgeGameStart BRIDGE_GAME_START = new BridgeGameStart();

    public void run() {
        outputView.printGameStartMessage();
        bridgeGame = BRIDGE_GAME_START.start(bridgeMaker, inputView);
        boolean game = true;

        while (game) {
            if (bridgeGame.isCheckGame()) {
                game = isPlayerMove();
            }
            outputView.printResult(bridgeGame);
        }
    }

    public boolean isPlayerMove() {
        String move = inputView.readMoving();
        boolean game = bridgeGame.move(move);
        outputView.printMap(bridgeGame);
        if (!game) {
            game = bridgeGame.retry(inputView.readGameCommand());
        }
        return game;
    }

}