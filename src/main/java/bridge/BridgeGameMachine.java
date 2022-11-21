package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.MovingMap;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameService bridgeGameService;

    public BridgeGameMachine(InputView inputView, OutputView outputView, BridgeGameService bridgeGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGameService = bridgeGameService;
    }

    public void play() {
        printStartGame();

        int bridgeSize = inputBridgeSize();
        BridgeGame bridgeGame = bridgeGameService.bridgeGame(bridgeSize);

        playBridgeGame(bridgeGame);

        printResult(bridgeGame);
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd()) {
            playOneTurn(bridgeGame);
        }
    }

    private void playOneTurn(BridgeGame bridgeGame) {
        String moving = inputMoving();
        bridgeGame.move(moving);
        printMovingMap(bridgeGame);

        if (bridgeGame.isGameFailed()) {
            checkRetry(bridgeGame);
        }
    }

    private void checkRetry(BridgeGame bridgeGame) {
        String gameCommand = inputGameCommand();
        if ("R".equals(gameCommand)) {
            bridgeGame.retry();
        }
        if ("Q".equals(gameCommand)) {
            bridgeGame.finishGame();
        }
    }

    private void printStartGame() {
        outputView.printStartGame();
        outputView.println();
    }

    private int inputBridgeSize() {
        int bridgeSize = inputView.readBridgeSize();
        outputView.println();
        return bridgeSize;
    }

    private String inputMoving() {
        return inputView.readMoving();
    }

    private void printMovingMap(BridgeGame bridgeGame) {
        MovingMap movingMap = bridgeGame.getMovingMap();
        outputView.printMap(movingMap);
        outputView.println();
    }

    private String inputGameCommand() {
        return inputView.readGameCommand();
    }

    private void printResult(BridgeGame bridgeGame) {
        MovingMap movingMap = bridgeGame.getMovingMap();
        boolean isClear = bridgeGame.isGameClear();
        int tryCount = bridgeGame.getTryCount();

        outputView.printResult(movingMap, isClear, tryCount);
    }
}
