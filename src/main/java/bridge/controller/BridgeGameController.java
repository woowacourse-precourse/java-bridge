package bridge.controller;

import bridge.model.GameResultState;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

import static bridge.model.GameResultState.LOSE;

public class BridgeGameController {

    private static final String RETRY_SIGN = "R";
    private static final String QUIT_SIGN = "Q";

    private static int totalTries = 0;
    private static int currentPosition = -1;
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
        currentPosition++;
        String move = inputView.printMoveMessage();
        boolean success = bridgeGameService.moveAndReturnSuccess(currentPosition, move);
        printMap();

        judgeProceed(success);
    }

    private void judgeProceed(final boolean success) {
        if (isLose(success)) {
            String gameCommand = inputView.printGameCommand();
            proceedOrQuitGame(gameCommand);

            printEndMessage(LOSE);
        }
    }

    private static boolean isLose(final boolean success) {
        return !success;
    }

    private void proceedOrQuitGame(final String gameCommand) {
        if (isRetryCommand(gameCommand)) {
            initialize();
            proceedGame();
        }
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
