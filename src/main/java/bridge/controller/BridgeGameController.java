package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.model.GameResultState;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.model.GameResultState.LOSE;
import static bridge.model.GameResultState.WIN;

public class BridgeGameController {

    private int bridgeSize;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void start(BridgeNumberGenerator generator) {
        initBridge(generator);
        proceedGame();
    }

    private void initBridge(final BridgeNumberGenerator generator) {
        bridgeSize = inputView.printStartMessage();
        bridgeGameService.makeBridge(bridgeSize, generator);
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
            final String move = inputView.printMoveMessage();
            final boolean success = bridgeGameService.moveAndReturnSuccess(move);
            printMap();
            proceed = judgeProceed(success);
        }
    }

    private boolean judgeProceed(final boolean success) {
        if (isLose(success)) {
            final String gameCommand = inputView.printGameCommand();
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
        return bridgeGameService.isRetryCommand(gameCommand);
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
        final List<String> upBridges = bridgeGameService.getUpBridges();
        final List<String> downBridges = bridgeGameService.getDownBridges();
        outputView.printMap(upBridges, downBridges);
    }
}
