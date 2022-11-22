package bridge;

public class GamePlayer {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private GameRecorder gameRecorder;
    private Command isExit = Command.RETRY;

    public void play() {
        gameRecorder = new GameRecorder(inputView.readBridgeSize());
        playGame();
        outputView.printResult(gameRecorder.getResult());
    }

    private void playGame() {
        while (isExit != Command.QUIT) {
            gameRecorder.start();
            cross();
            if (gameRecorder.getResult().getGameClear()) {
                break;
            }
            isExit = inputView.readGameCommand();
        }
    }

    private void cross() {
        while (!gameRecorder.getResult().getGameClear()) {
            boolean crossResult = gameRecorder.recordMove(inputView.readMoving());
            outputView.printMap(gameRecorder.getResult().getBridgeMap());
            if (!crossResult) {
                break;
            }
        }
    }
}
