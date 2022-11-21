package bridge;

public class GamePlayer {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private int bridgeSize = 0;
    private BridgeGame bridgeGame;
    private int tryCount = 0;
    private int position = 0;
    private Command isExit = Command.RETRY;
    private boolean isGameClear = false;
    private BridgeMap bridgeMap = new BridgeMap();
    public void play() {
        bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);

        isGameClear = playGame();
        outputView.printResult(bridgeMap, isGameClear, tryCount);
    }

    private boolean playGame() {
        while (isExit != Command.QUIT) {
            bridgeMap = new BridgeMap();
            tryCount++;
            cross();
            if (checkSuccessCross()) break;
            bridgeGame.retry();
            position = 0;
            isExit = inputView.readGameCommand();
        }
        return isGameClear;
    }

    private boolean checkSuccessCross() {
        if (position == bridgeSize) {
            isGameClear = true;
            return true;
        }
        return false;
    }

    private void cross() {
        while (position < bridgeSize) {
            Command moveCommand = inputView.readMoving();
            if (isMoveFail(moveCommand)) break;
            bridgeMap.moveSuccess(moveCommand);
            outputView.printMap(bridgeMap);
            position++;
        }
    }

    private boolean isMoveFail(Command moveCommand) {
        if (!bridgeGame.move(moveCommand)) {
            bridgeMap.moveFail(moveCommand);
            outputView.printMap(bridgeMap);
            return true;
        }
        return false;
    }
}
