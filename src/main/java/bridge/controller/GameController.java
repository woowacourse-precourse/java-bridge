package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.GameStatus;
import bridge.dto.GameResultDto;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final BridgeGame bridgeGame;

    public GameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        OutputView.printGameStart();

        OutputView.printBridgeSize();
        int bridgeSize = InputView.readBridgeSize();
        OutputView.printBlank();

        bridgeGame.createBridge(bridgeSize, new BridgeRandomNumberGenerator());

        recursive(1);
    }

    public void recursive(int round) {
        OutputView.printMove();
        String mark = InputView.readMoving();

        GameStatus gameStatus = bridgeGame.move(round, mark);
        GameResultDto gameResult = bridgeGame.getGameReport();
        OutputView.printMap(gameStatus, gameResult);

        checkGameStatus(round, gameStatus, gameResult);
    }

    private void checkGameStatus(int round, GameStatus gameStatus, GameResultDto gameResult) {
        if (gameStatus.isFail()) {
            checkRestart(gameStatus, gameResult);
        }
        if (gameStatus.isSuccess()) {
            OutputView.printResult(gameStatus, gameResult);
        }
        if (gameStatus.isContinue()) {
            recursive(round + 1);
        }
    }

    private void checkRestart(GameStatus gameStatus, GameResultDto gameResult) {
        OutputView.printRestart();
        String restart = InputView.readGameCommand();

        if (restart.equals("R")) {
            bridgeGame.retry();
            recursive(1);
        }
        if (restart.equals("Q")) {
            OutputView.printResult(gameStatus, gameResult);
        }
    }
}
