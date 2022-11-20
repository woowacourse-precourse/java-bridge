package bridge.controller;

import bridge.domain.MoveResult;
import bridge.domain.Player;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGameService bridgeGameService;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
    }

    public void run() {
        outputView.printGameStart();

        int size = readBridgeSize();
        bridgeGameService.initializeBridgeGame(size);

        Player player = new Player();

        while (bridgeGameService.isPlayable()) {
            String move = readMoving();
            List<List<MoveResult>> result = bridgeGameService.play(player, move);
            outputView.printMap(result);

            if (!bridgeGameService.isPlayable()) {
                String command = readGameCommand();
                bridgeGameService.retry(player, command);
            }
        }
    }

    private int readBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    private String readMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readMoving();
        }
    }

    private String readGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readGameCommand();
        }
    }
}
