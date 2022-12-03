package bridge.controller;

import static bridge.exception.Error.*;
import static bridge.exception.Validator.validGameCommand;
import static bridge.view.OutputView.*;
import static bridge.view.InputView.*;

import bridge.domain.GameCommand;
import bridge.service.BridgeGame;

public class BridgeGameController {

    private BridgeGame bridgeGame;
    private int totalNumberOfAttempts = 1;

    public void execute() {
        printBridgeGameStartMessage();

        int bridgeSize = inputBridgeSize();
        initializeBridgeGameByBridgeSize(bridgeSize);

        while (inputMoving(bridgeSize) != GameCommand.QUIT) {
            bridgeGame.retry();
            totalNumberOfAttempts++;
        }

        gameQuit();
    }

    public GameCommand inputMoving(int bridgeSize) {
        for (int i = 0; i < bridgeSize; i++) {
            bridgeGame.move(readMoving());

            printMap(bridgeGame.getRounds());

            if (bridgeGame.isCurrentRoundResultFailure()) {
                return validGameCommand(readGameCommand());
            }
        }
        return GameCommand.QUIT;
    }

    public void gameQuit() {
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

}
