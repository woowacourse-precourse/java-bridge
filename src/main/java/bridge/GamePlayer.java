package bridge;

public class GamePlayer {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private GameStatus gameStatus;
    private Command isExit = Command.RETRY;

    public void play() {
        gameStatus = new GameStatus(inputView.readBridgeSize());
        playGame();
        outputView.printResult(gameStatus.getResult());
    }

    private void playGame() {
        while (isExit != Command.QUIT) {
            gameStatus.retry();
            cross();
            if (gameStatus.getResult().getGameClear()) {
                break;
            }
            isExit = inputView.readGameCommand();
        }
    }

    private void cross() {
        while (!gameStatus.getResult().getGameClear()) {
            boolean crossResult = gameStatus.cross(inputView.readMoving());
            outputView.printMap(gameStatus.getResult().getBridgeMap());
            if (!crossResult) {
                break;
            }
        }
    }
}
