package controller.services;

import constants.BridgeConstant;
import constants.CommandTable;
import constants.ResultTable;
import controller.MapConverter;
import model.Bridge;
import model.GameResult;
import model.User;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GamePlay {
    private Bridge bridge;
    private User user;

    public GamePlay(List<String> bridgeMap) {
        bridge = new Bridge(bridgeMap);
    }

    public GameResult playGame() {
        for (int countOfAttempt = 1; isNotOverMaxCountOfAttempt(countOfAttempt); countOfAttempt++) {
            int commandNumber = tryGameOnce();

            if (isEndingCommandNumber(commandNumber)) {
                return new GameResult(user, commandNumber, countOfAttempt);
            }
        }
        return new GameResult(user, ResultTable.END.getResultNumber(), BridgeConstant.MAX_COUNT_OF_ATTEMPT);
    }

    private boolean isEndingCommandNumber(int commandNumber) {
        return commandNumber != CommandTable.RETRY.getCommandNumber();
    }

    private boolean isNotOverMaxCountOfAttempt(int countOfAttempt) {
        return countOfAttempt <= BridgeConstant.MAX_COUNT_OF_ATTEMPT;
    }

    private int tryGameOnce() {
        BridgeGame bridgeGame = loadBridgeGame();

        for (; bridge.isUnderBridgeSize(user.getUserMovingDistance()); ) {
            if (isGameOver(bridgeGame)) {
                return bridgeGame.retry(InputView.readGameCommand());
            }
        }
        return ResultTable.PASS.getResultNumber();
    }

    private BridgeGame loadBridgeGame() {
        user = new User();
        return new BridgeGame(bridge, user);
    }

    private boolean isGameOver(BridgeGame bridgeGame) {
        boolean result = tryMove(bridgeGame);
        printProgress();

        return result;
    }

    private boolean tryMove(BridgeGame bridgeGame) {
        return bridgeGame.move(InputView.readMoving());
    }

    private void printProgress() {
        OutputView.printMap(MapConverter.convertMap(user.getUserMap()));
    }
}
