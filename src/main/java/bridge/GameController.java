package bridge;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private int bridgeSize;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        bridgeSize = Integer.parseInt(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        runGame(bridgeGame);
        endGame(bridgeGame);
    }

    public void runGame(BridgeGame bridgeGame) {
        do {
            do {
                bridgeGame.addPlayerBridge(inputView.readMoving());
                outputView.printMap(bridgeGame.getPlayerBridge());
                bridgeGame.move();
            } while (bridgeGame.checkCanMove());
        } while (checkRetry(bridgeGame));
    }

    public void endGame(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame.getPlayerBridge(), bridgeGame.getIsSuccess());
        outputView.printTotalAttempts(bridgeGame.getCountAttempts());
    }

    public boolean checkRetry(BridgeGame bridgeGame) {
        if (isPlayerArrive(bridgeGame) || getGameCommand(bridgeGame).equals("Q")) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    public boolean isPlayerArrive(BridgeGame bridgeGame) {
        return bridgeGame.getPlayerBridgePosition() == (bridgeSize) && (bridgeGame.getCurrentIsCorrect().equals("O"));
    }

    public String getGameCommand(BridgeGame bridgeGame) {
        String gameCommand;
        gameCommand = inputView.readGameCommand();

        if (gameCommand.equals("Q")) {
            bridgeGame.changeToLoose();
        }
        return gameCommand;
    }
}
