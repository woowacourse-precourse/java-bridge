package bridge;

public class GamePlayer {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private GameRecorder gameRecoder;
    private Command isExit = Command.RETRY;

    public void play() {
        gameRecoder = new GameRecorder(inputView.readBridgeSize());
        playGame();
        outputView.printResult(gameRecoder.getResult());
    }

    private void playGame() {
        while (isExit != Command.QUIT) {
            gameRecoder.retry();
            cross();
            if (gameRecoder.getResult().getGameClear()) {
                break;
            }
            isExit = inputView.readGameCommand();
        }
    }

    private void cross() {
        while (!gameRecoder.getResult().getGameClear()) {
            boolean crossResult = gameRecoder.cross(inputView.readMoving());
            outputView.printMap(gameRecoder.getResult().getBridgeMap());
            if (!crossResult) {
                break;
            }
        }
    }
}
