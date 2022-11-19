package controller.services;

import constants.*;
import controller.MapConverter;
import model.*;
import view.*;

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
        user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        for (; user.getUserMovingDistance() < bridge.getBridgeSize(); ) {
            if (isInaccessibleNextPosition(bridgeGame)) {
                return bridgeGame.retry(InputView.readGameCommand());
            }
        }
        return ResultTable.PASS.getResultNumber();
    }

    private boolean isInaccessibleNextPosition(BridgeGame bridgeGame) {
        boolean result = bridgeGame.move(InputView.readMoving());
        OutputView.printMap(MapConverter.convertMap(user.getUserMap()));

        return result;
    }
}
