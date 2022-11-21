package bridge.controller;

import bridge.model.GameResultState;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

import static bridge.model.GameCommand.RETRY;
import static bridge.model.GameResultState.LOSE;
import static bridge.model.GameResultState.WIN;

public class BridgeGameController {

    private int bridgeSize;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void start() {
        initBridge();
        proceedGame();
    }

    private void initBridge() {
        bridgeSize = inputView.printStartMessage();
        bridgeGameService.makeBridge(bridgeSize);
    }

    private void proceedGame() {
        doGame();
        judgeResult();
    }

    private void judgeResult() {
        if (isEndPosition()) {
            printEndMessage(WIN);
            return;
        }

        printEndMessage(LOSE);
    }

    private void doGame() {
        boolean proceed = true;

        while (proceed) {
            String move = inputView.printMoveMessage();
            boolean success = bridgeGameService.moveAndReturnSuccess(move);
            printMap();
            proceed = judgeProceed(success);
        }
    }

    private boolean judgeProceed(final boolean success) {
        if (isLose(success)) {
            String gameCommand = inputView.printGameCommand();
            return proceedOrQuitGame(gameCommand);
        }

        return judgeIfWin();
    }

    private boolean isLose(final boolean success) {
        return !success;
    }

    private boolean proceedOrQuitGame(final String gameCommand) {
        if (isRetryCommand(gameCommand)) {
            initialize();
            return true;
        }

        return false;
    }

    private boolean judgeIfWin() {
        if (isEndPosition()) {
            return false;
        }

        bridgeGameService.increasePosition();
        return true;
    }

    private boolean isEndPosition() {
        return bridgeGameService.isEndPosition(bridgeSize);
    }

    private boolean isRetryCommand(final String gameCommand) {
        return Objects.equals(gameCommand, RETRY.getSign());
    }

    private void initialize() {
        bridgeGameService.initializePosition();
        bridgeGameService.increaseTries();
        bridgeGameService.clearRepository();
    }

    private void printEndMessage(GameResultState state) {
        outputView.printResultMessage();
        printMap();
        outputView.printResult(state, bridgeGameService.getTotalTries());
    }

    private void printMap() {
        List<String> upBridges = bridgeGameService.getUpBridges();
        List<String> downBridges = bridgeGameService.getDownBridges();
        outputView.printMap(upBridges, downBridges);
    }
}
