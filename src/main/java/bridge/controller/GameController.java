package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.GameCommand;
import bridge.constant.GameStatus;
import bridge.dto.GameResultDto;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    public static final int START_ROUND = 1;
    public static final int ROUND_INCREMENT_VALUE = 1;
    public static final String RESTART = "R";
    public static final String QUIT = "Q";

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
        recursiveRound(START_ROUND);
    }

    public void recursiveRound(int round) {
        OutputView.printMove();
        String movingMark = InputView.readMoving();

        GameResultDto gameResult = bridgeGame.move(round, movingMark);
        OutputView.printMap(gameResult);

        checkNextRound(round, gameResult);
    }

    private void checkNextRound(int round, GameResultDto gameResult) {
        GameStatus gameStatus = gameResult.getGameStatus();
        if (gameStatus.isSuccess()) {
            OutputView.printResult(gameResult);
        }
        if (gameStatus.isFail()) {
            checkRestart(gameResult);
        }
        if (gameStatus.isContinue()) {
            recursiveRound(round + ROUND_INCREMENT_VALUE);
        }
    }

    private void checkRestart(GameResultDto gameResult) {
        OutputView.printRestart();
        String command = InputView.readGameCommand();
        GameCommand gameCommand = GameCommand.of(command);
        if (gameCommand.isRestart()) {
            bridgeGame.retry();
            recursiveRound(START_ROUND);
        }
        if (gameCommand.isQuit()) {
            OutputView.printResult(gameResult);
        }
    }
}
