package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

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
        gameProceed();
    }

    private void initBridge() {
        bridgeSize = inputView.printStartMessage();
        bridgeGameService.makeBridge(bridgeSize);
    }

    private void gameProceed() {
        currentPosition++;
        String move = inputView.printMoveMessage();
        boolean success = bridgeGameService.moveAndReturnSuccess(currentPosition, move);
        printIntermediateResult();

        if (!success) {
            String gameCommand = inputView.printGameCommand();
            if (Objects.equals(gameCommand, RETRY_SIGN)) {
                currentPosition = 0;
                totalTries++;
                bridgeGameService.clearRepository();
                gameProceed();
                return;
            }
        }
    }

    private void printIntermediateResult() {
        List<String> upBridges = bridgeGameService.getUpBridges();
        List<String> downBridges = bridgeGameService.getDownBridges();
        outputView.printMap(upBridges, downBridges);
    }
}
