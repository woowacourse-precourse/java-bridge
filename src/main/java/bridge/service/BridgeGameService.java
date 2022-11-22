package bridge.service;

import static bridge.exception.Error.*;
import static bridge.exception.Validator.validGameCommand;
import static bridge.view.OutputView.*;

import bridge.domain.GameCommand;
import bridge.domain.Round;
import bridge.domain.RoundResult;
import bridge.exception.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.Objects;

public class BridgeGameService {

    private BridgeGame bridgeGame;

    public void execute() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        printBridgeGameStartMessage();

        try {
            initializeBridgeGameByBridgeSize(inputView.readBridgeSize());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }

        int totalNumberOfAttempts = 1;
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            bridgeGame.move(inputView.readMoving());

            outputView.printMap(bridgeGame.getRounds());

            if (bridgeGame.isCurrentRoundResultFailure()) {
                if (isGameRetry(inputView.readGameCommand())) {
                    bridgeGame.retry();
                    totalNumberOfAttempts += 1;
                } else {
                    break;
                }
            }
        }
        outputView.printResult(bridgeGame.getRounds(), totalNumberOfAttempts);
    }

    private void initializeBridgeGameByBridgeSize(int size) {
        bridgeGame = new BridgeGame(size);
    }

    private boolean isGameRetry(String gameCommand) {
        validGameCommand(gameCommand);
        if (gameCommand.equals(GameCommand.RETRY.getExpression())) {
            return true;
        }
        return false;
    }

}
