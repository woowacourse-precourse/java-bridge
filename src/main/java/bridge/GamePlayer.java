package bridge;

public class GamePlayer {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame game = new BridgeGame(bridgeSize);
        int tryCount = 0;
        int position = 0;
        InputType isExit = InputType.RETRY;
        BridgeMap bridgeMap = new BridgeMap();
        boolean isGameClear = false;
        while (isExit != InputType.QUIT) {
            bridgeMap = new BridgeMap();
            tryCount++;
            while (position < bridgeSize) {
                InputType moveCommand = inputView.readMoving();
                if (!game.move(moveCommand)) {
                    bridgeMap.moveFail(moveCommand);
                    outputView.printMap(bridgeMap);
                    break;
                }

                bridgeMap.moveSuccess(moveCommand);
                outputView.printMap(bridgeMap);
                position++;
            }
            if (position == bridgeSize) {
                isGameClear = true;
                break;
            }
            game.retry();
            position = 0;
            isExit = inputView.readGameCommand();
        }
        outputView.printResult(bridgeMap, isGameClear, tryCount);
    }
}
