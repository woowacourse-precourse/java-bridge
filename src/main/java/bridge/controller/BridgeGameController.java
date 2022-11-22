package bridge.controller;

import bridge.domain.Attempt;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.service.BridgeGame;

import java.util.List;
import java.util.Objects;

import static bridge.enums.GameCommand.QUIT;
import static bridge.enums.GameCommand.RETRY;

public class BridgeGameController {

    private final String NULL_MESSAGE = "";
    private final BridgeGame bridgeGame;
    private final OutputView outputView;
    private final InputView inputView;
    private final Attempt attempt;

    public BridgeGameController(BridgeGame bridgeGame, Attempt attempt) {
        this.bridgeGame = bridgeGame;
        this.attempt = attempt;
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void execute() {
        String retry;
        do {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            printBridges();
            retry = initRetryMessage();
        } while (isGameFail() && isGameNotQuit(retry));
    }

    String initRetryMessage() {
        if (bridgeGame.isFail()) {
            return inputView.readGameCommand();
        }
        return NULL_MESSAGE;
    }

    boolean isGameFail() {
        List<String> upperBridges = bridgeGame.getUpperBridges();
        List<String> lowerBridges = bridgeGame.getLowerBridges();
        if (bridgeGame.isMatchBridgesSize() && !bridgeGame.isFail()) {
            outputView.printResult(upperBridges, lowerBridges);
            outputView.printResultMessage(true);
            return false;
        }
        return true;
    }

    boolean isGameNotQuit(String retry) {
        if (Objects.equals(retry, QUIT.getCommand())) {
            outputView.printResult(bridgeGame.getUpperBridges(), bridgeGame.getLowerBridges());
            outputView.printResultMessage(false);
            return false;
        }
        if (Objects.equals(retry, RETRY.getCommand())) {
            bridgeGame.retry(attempt);
        }
        return true;
    }

    void printBridges() {
        outputView.printMap(bridgeGame.getUpperBridges());
        outputView.printMap(bridgeGame.getLowerBridges());
    }

    public int getAttemptCount() {
        return attempt.getCount();
    }
}
