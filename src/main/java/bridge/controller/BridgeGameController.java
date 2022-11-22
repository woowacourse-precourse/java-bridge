package bridge.controller;

import static bridge.exception.Error.*;
import static bridge.exception.Validator.validGameCommand;
import static bridge.view.OutputView.*;
import static bridge.view.InputView.*;

import bridge.domain.GameCommand;
import bridge.service.BridgeGame;

public class BridgeGameController {

    private BridgeGame bridgeGame;

    public void execute() {
        printBridgeGameStartMessage();

        int bridgeSize = inputBridgeSize();
        initializeBridgeGameByBridgeSize(bridgeSize);

        int totalNumberOfAttempts = 1;
        for (int i = 0; i < bridgeSize; i++) {
            bridgeGame.move(readMoving());

            printMap(bridgeGame.getRounds());

            if (bridgeGame.isCurrentRoundResultFailure()) {
                if (isGameRetry(readGameCommand())) {
                    bridgeGame.retry();
                    totalNumberOfAttempts += 1;
                } else {
                    break;
                }
            }
        }
        printResult(bridgeGame.getRounds(), totalNumberOfAttempts);
    }

    public int inputBridgeSize() {
        try {
            return readBridgeSize();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }
    }

    public void initializeBridgeGameByBridgeSize(int size) {
        bridgeGame = new BridgeGame(size);
    }

    public boolean isGameRetry(String gameCommand) {
        validGameCommand(gameCommand);
        return gameCommand.equals(GameCommand.RETRY.getExpression());
    }

}
