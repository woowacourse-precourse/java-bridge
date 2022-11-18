package controller.services;

import constants.CommandTable;
import constants.ResultTable;
import controller.MapConverter;
import model.Bridge;
import model.User;
import model.GameResult;
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
        for (int countOfAttempt = 1; ; countOfAttempt++) {
            int commandNumber = tryGameOnce();

            if (isEndingCommandNumber(commandNumber)) {
                return new GameResult(user,commandNumber,countOfAttempt);
            }
        }
    }

    private boolean isEndingCommandNumber(int commandNumber) {
        return commandNumber != CommandTable.RETRY.getCommandNumber();
    }

    private int tryGameOnce() {
        user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        for (;user.getUserMovingDistance() < bridge.getBridgeSize();) {
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
