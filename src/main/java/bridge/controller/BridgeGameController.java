package bridge.controller;

import bridge.model.GameResultState;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

import static bridge.model.GameResultState.LOSE;
import static bridge.model.GameResultState.WIN;

public class BridgeGameController {

    private static final String RETRY_SIGN = "R";

    private static int totalTries = 1;
    private static int currentPosition = 0;
    private static int bridgeSize;

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
            boolean success = bridgeGameService.moveAndReturnSuccess(currentPosition, move);
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

    private static boolean isLose(final boolean success) {
        return !success;
    }

    private boolean proceedOrQuitGame(final String gameCommand) {
        if (isRetryCommand(gameCommand)) {
            initialize();
            return true;
        }

        return false;
    }

    private static boolean judgeIfWin() {
        if (isEndPosition()) {
            return false;
        }
        currentPosition++;
        return true;
    }

    private static boolean isEndPosition() {
        return currentPosition == bridgeSize - 1;
    }

    private static boolean isRetryCommand(final String gameCommand) {
        return Objects.equals(gameCommand, RETRY_SIGN);
    }

    private void initialize() {
        currentPosition = 0;
        totalTries++;
        bridgeGameService.clearRepository();
    }

    private void printEndMessage(GameResultState state) {
        outputView.printResultMessage();
        printMap();
        outputView.printResult(state, totalTries);
    }

    private void printMap() {
        List<String> upBridges = bridgeGameService.getUpBridges();
        List<String> downBridges = bridgeGameService.getDownBridges();
        outputView.printMap(upBridges, downBridges);
    }
}
